package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.Book;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.BookReservationCommand;

import java.util.ArrayList;

public class ReservationTestData {

    public static BookReservationCommand anyBookReservation(Long bookId, Long userId){
        return BookReservationCommand.builder()
                .bookId(bookId)
                .userId(userId)
                .build();
    }

    public static AvailableBook anyAvailableBook(Long bookId){
        return new AvailableBook(bookId);
    }

    public static ActiveUser anyActiveUser(Long userId){
        return new ActiveUser(userId, new ArrayList<Book>());
    }
}
