package io.wkrzywiec.hexagonal.library.borrowing.infrastructure;

import lombok.Data;

@Data
public class OverdueReservationEntity {
    private Long reservationId;
    private Long bookIdentification;
}
