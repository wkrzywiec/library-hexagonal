package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowBookCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.GiveBackBookCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservedBook;

import java.util.ArrayList;
import java.util.List;

public class BorrowTestData {

    public static BorrowBookCommand anyBorrowBookCommand(Long bookId, Long userId){
        return BorrowBookCommand.builder()
                .bookId(bookId)
                .userId(userId)
                .build();
    }

    public static GiveBackBookCommand anyGiveBookCommand(Long bookId, Long userId){
        return GiveBackBookCommand.builder()
                .bookId(bookId)
                .userId(userId)
                .build();
    }

    public static ReservedBook anyReservedBook(Long bookId, Long userId){
        return new ReservedBook(bookId, userId);
    }

    public static BorrowedBook anyBorrowedBook(Long bookId, Long userId){
        return new BorrowedBook(bookId, userId);
    }

    public static ActiveUser anyActiveUser(Long userId){
        return new ActiveUser(userId, new ArrayList<ReservedBook>(), new ArrayList<BorrowedBook>());
    }

    public static ActiveUser anyActiveUserWithReservedBooks(Long userId, List<ReservedBook> reservedBookList){
        return new ActiveUser(userId, reservedBookList, new ArrayList<BorrowedBook>());
    }

    public static ActiveUser anyActiveUserWithBorrowedBooks(Long userId, List<BorrowedBook> borrowedBooksList){
        return new ActiveUser(userId, new ArrayList<ReservedBook>(), borrowedBooksList);
    }

}
