package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowBookCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservedBook;

import java.util.ArrayList;

public class BorrowTestData {

    public static BorrowBookCommand anyBorrowBookCommand(Long bookId, Long userId){
        return BorrowBookCommand.builder()
                .bookId(bookId)
                .userId(userId)
                .build();
    }

    public static ReservedBook anyReservedBook(Long bookId, Long userId){
        return new ReservedBook(bookId, userId);
    }

    public static ActiveUser anyActiveUser(Long userId){
        return new ActiveUser(userId, new ArrayList<ReservedBook>(), new ArrayList<BorrowedBook>());
    }
}
