package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OverdueReservation {
    private Long reservationId;
    private Long bookIdentification;

    public Long getBookIdentificationAsLong() {
        return bookIdentification;
    }
}
