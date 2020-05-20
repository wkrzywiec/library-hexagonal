package io.wkrzywiec.hexagonal.library.borrowing;

import io.wkrzywiec.hexagonal.library.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.borrowing.model.MakeBookAvailableCommand;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.borrowing.model.exception.ActiveUserNotFoundException;
import io.wkrzywiec.hexagonal.library.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.borrowing.model.exception.AvailableBookNotFoundExeption;
import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservedBook;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.ReserveBook;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingDatabase;

public class BorrowingFacade implements MakeBookAvailable, ReserveBook {

    private BorrowingDatabase database;

    public BorrowingFacade(BorrowingDatabase database) {
        this.database = database;
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
        return reservationDetails.getReservationId().getIdAsLong();
    }
}
