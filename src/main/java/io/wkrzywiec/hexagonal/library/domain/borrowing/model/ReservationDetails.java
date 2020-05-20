package io.wkrzywiec.hexagonal.library.domain.borrowing.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class ReservationDetails {

    private final ReservationId reservationId;
    private final ReservedBook reservedBook;

    public ReservationDetails(ReservationId reservationId, ReservedBook reservedBook) {
        this.reservationId = reservationId;
        this.reservedBook = reservedBook;
    }
}
