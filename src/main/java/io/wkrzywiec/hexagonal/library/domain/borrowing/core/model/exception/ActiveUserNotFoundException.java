package io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.exception;

public class ActiveUserNotFoundException extends RuntimeException {
    public ActiveUserNotFoundException(Long bookId){
        super("There is no active user with an ID: " + bookId,
                null,
                false,
                false);
    }
}
