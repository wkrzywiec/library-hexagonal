package io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.exception;

public class TooManyBooksAssignedToUserException extends RuntimeException {
    public TooManyBooksAssignedToUserException(Long userId){
        super("You can't assign another book to user account: " + userId + ". Reason: Too many books already assigned.",
                null,
                false,
                false);
    }
}
