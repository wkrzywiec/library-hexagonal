package io.wkrzywiec.hexagonal.library.domain.borrowing.core;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.DueDate;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.MakeBookAvailableCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.OverdueReservation;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.exception.ActiveUserNotFoundException;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.exception.AvailableBookNotFoundExeption;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.CancelOverdueReservations;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.ReserveBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingDatabase;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingEventPublisher;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BorrowingFacade implements MakeBookAvailable, ReserveBook, CancelOverdueReservations {

    private final BorrowingDatabase database;
    private final BorrowingEventPublisher eventPublisher;

    public BorrowingFacade(BorrowingDatabase database, BorrowingEventPublisher eventPublisher) {
        this.database = database;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void handle(MakeBookAvailableCommand bookAvailableCommand) {
        database.setBookAvailable(bookAvailableCommand.getBookId());
    }

    @Override
    public Long handle(BookReservationCommand bookReservation) {
        AvailableBook availableBook =
                database.getAvailableBook(bookReservation.getBookId())
                .orElseThrow(() -> new AvailableBookNotFoundExeption(bookReservation.getBookId()));

        ActiveUser activeUser =
                database.getActiveUser(bookReservation.getUserId())
                .orElseThrow(() -> new ActiveUserNotFoundException(bookReservation.getUserId()));

        ReservedBook reservedBook = activeUser.reserve(availableBook);
        ReservationDetails reservationDetails = database.save(reservedBook);
        eventPublisher.publish(new BookReservedEvent(reservationDetails));
        return reservationDetails.getReservationId().getIdAsLong();
    }

    @Override
    public void cancelOverdueReservations() {
        DueDate dueDate = new DueDate(Instant.now().plus(3L, ChronoUnit.DAYS));
        List<OverdueReservation> overdueReservationList = database.findReservationsAfter(dueDate);
        overdueReservationList.forEach(
                overdue -> database.setBookAvailable(overdue.getBookIdentificationAsLong()));
    }
}
