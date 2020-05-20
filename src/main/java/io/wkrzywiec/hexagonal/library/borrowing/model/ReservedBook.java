package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ReservedBook implements Book {

    private final Long bookId;
    private final Long userId;

    public ReservedBook(Long bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    @Override
    public Long getIdAsLong() {
        return bookId;
    }

    public Long getAssignedUserIdAsLong(){
        return userId;
    }
}
