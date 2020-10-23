package io.wkrzywiec.hexagonal.library.domain.borrowing.core.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@EqualsAndHashCode
public class ReservedBook implements Book {

    private final Long bookId;
    private final Long userId;
    private final Instant reservedDate;

    public ReservedBook(Long bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.reservedDate = Instant.now();
    }

    public ReservedBook(Long bookId, Long userId, Instant reservedDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.reservedDate = reservedDate;
    }

    @Override
    public Long getIdAsLong() {
        return bookId;
    }

    public Long getAssignedUserIdAsLong(){
        return userId;
    }

    public Instant getReservedDateAsInstant(){
        return reservedDate;
    }
}
