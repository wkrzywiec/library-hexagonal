package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OverdueReservation {
    private final ReservationId reservationId;
    private final BookIdentification bookIdentification;

    public Long getBookIdentificationAsLong() {
        return bookIdentification.getValueAsLong();
    }
}
