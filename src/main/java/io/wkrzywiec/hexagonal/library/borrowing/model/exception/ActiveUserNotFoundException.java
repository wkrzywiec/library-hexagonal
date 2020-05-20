package io.wkrzywiec.hexagonal.library.borrowing.model.exception;

public class ActiveUserNotFoundException extends RuntimeException {
    public ActiveUserNotFoundException(Long bookId){
        super("There is no active user with an ID: " + bookId,
                null,
                false,
                false);
    }
}
