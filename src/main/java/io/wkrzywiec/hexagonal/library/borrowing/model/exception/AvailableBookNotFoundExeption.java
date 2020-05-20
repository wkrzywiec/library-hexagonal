package io.wkrzywiec.hexagonal.library.borrowing.model.exception;

public class AvailableBookNotFoundExeption extends RuntimeException {
    public AvailableBookNotFoundExeption(Long bookId){
        super("There is no available book with an ID: " + bookId,
                null,
                false,
                false);
    }
}
