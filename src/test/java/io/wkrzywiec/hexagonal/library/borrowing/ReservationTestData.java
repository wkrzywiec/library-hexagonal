package io.wkrzywiec.hexagonal.library.borrowing;

import io.wkrzywiec.hexagonal.library.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservedBook;

import java.util.ArrayList;

public class ReservationTestData {

    public static BookReservationCommand anyBookReservationCommand(Long bookId, Long userId){
        return BookReservationCommand.builder()
                .bookId(bookId)
                .userId(userId)
                .build();
    }

    public static ReservedBook anyReservedBook(Long bookId, Long userId){
        return new ReservedBook(bookId, userId);
    }

    public static AvailableBook anyAvailableBook(Long bookId){
        return new AvailableBook(bookId);
    }

    public static ActiveUser anyActiveUser(Long userId){
        return new ActiveUser(userId, new ArrayList<ReservedBook>());
    }
}
