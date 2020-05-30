package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservedBook;

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
