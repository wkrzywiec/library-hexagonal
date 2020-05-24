package io.wkrzywiec.hexagonal.library.inventory.model;

import java.time.Instant;

public class NewBookWasAddedEvent {

    private final Long bookId;
    private final Instant timestamp;

    public NewBookWasAddedEvent(Long bookId) {
        this.bookId = bookId;
        timestamp = Instant.now();
    }

    public Long getBookIdAsLong() {
        return bookId;
    }

    public String getEventTimeStampAsString() {
        return timestamp.toString();
    }
}
