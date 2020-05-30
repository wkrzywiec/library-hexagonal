package io.wkrzywiec.hexagonal.library.domain.borrowing.core.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OverdueReservation {
    private Long reservationId;
    private Long bookIdentification;

    public Long getBookIdentificationAsLong() {
        return bookIdentification;
    }
}
