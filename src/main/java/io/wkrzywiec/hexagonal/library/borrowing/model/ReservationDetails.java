package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ReservationDetails {

    private final ReservationId reservationId;
    private final ReservedBook reservedBook;

    public ReservationDetails(ReservationId reservationId, ReservedBook reservedBook) {
        this.reservationId = reservationId;
        this.reservedBook = reservedBook;
    }
}
