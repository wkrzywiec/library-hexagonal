package io.wkrzywiec.hexagonal.library.borrowing.model;

import java.time.Instant;

public class BookReservedEvent {

    private final ReservationId reservationId;
    private final Long userId;
    private final ReservedBook reservedBook;
    private final Instant timestamp;

    public BookReservedEvent(ReservationDetails reservationDetails) {
        this.reservationId = reservationDetails.getReservationId();
        this.userId = reservationDetails.getReservedBook().getAssignedUserIdAsLong();
        this.reservedBook = reservationDetails.getReservedBook();
        timestamp = Instant.now();
    }

    public Long getReservationIdAsLong() {
        return reservationId.getIdAsLong();
    }

    public Long getUserIdAsLong() {
        return userId;
    }

    public Long getBookIdAsLong() {
        return reservedBook.getIdAsLong();
    }

    public String getEventTimeStampAsString() {
        return timestamp.toString();
    }

}
