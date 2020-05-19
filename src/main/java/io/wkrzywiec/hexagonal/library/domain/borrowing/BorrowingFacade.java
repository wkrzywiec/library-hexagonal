package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.MakeBookAvailableCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.exception.ActiveUserNotFoundException;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.exception.AvailableBookNotFoundExeption;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ReservedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.domain.borrowing.ports.incoming.ReserveBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing.BorrowingDatabase;
import io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing.EmailSender;

public class BorrowingFacade implements MakeBookAvailable, ReserveBook {

    private BorrowingDatabase database;
    private EmailSender emailSender;

    public BorrowingFacade(BorrowingDatabase database, EmailSender emailSender) {
        this.database = database;
        this.emailSender = emailSender;
    }

    @Override
    public void handle(MakeBookAvailableCommand bookAvailableCommand) {
        database.setBookAvailable(bookAvailableCommand.getBookId());
    }

    @Override
    public void handle(BookReservationCommand bookReservation) {
        AvailableBook availableBook =
                database.getAvailableBook(bookReservation.getBookId())
                .orElseThrow(() -> new AvailableBookNotFoundExeption(bookReservation.getBookId()));

        ActiveUser activeUser =
                database.getActiveUser(bookReservation.getUserId())
                .orElseThrow(() -> new ActiveUserNotFoundException(bookReservation.getUserId()));

        ReservedBook reservedBook = availableBook.reserve();
        activeUser.assign(reservedBook);
        database.saveReservationFor(activeUser, reservedBook);

        emailSender.sendReservationConfirmationEmail(activeUser, reservedBook);
    }
}
