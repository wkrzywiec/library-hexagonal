package io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.entity;

import lombok.Data;

@Data
public class OverdueReservationEntity {
    private Long reservationId;
    private Long bookIdentification;
}
