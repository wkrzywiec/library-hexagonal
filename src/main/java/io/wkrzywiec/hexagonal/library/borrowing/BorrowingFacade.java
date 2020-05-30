package io.wkrzywiec.hexagonal.library.borrowing;

import io.wkrzywiec.hexagonal.library.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.borrowing.model.Days;
import io.wkrzywiec.hexagonal.library.borrowing.model.DueDate;
import io.wkrzywiec.hexagonal.library.borrowing.model.MakeBookAvailableCommand;
import io.wkrzywiec.hexagonal.library.borrowing.model.OverdueReservation;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.borrowing.model.exception.ActiveUserNotFoundException;
import io.wkrzywiec.hexagonal.library.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.borrowing.model.exception.AvailableBookNotFoundExeption;
import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservedBook;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.CancelOverdueReservations;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.ReserveBook;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingDatabase;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingEventPublisher;

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
