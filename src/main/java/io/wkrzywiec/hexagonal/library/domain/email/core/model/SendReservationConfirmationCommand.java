package io.wkrzywiec.hexagonal.library.domain.email.core.model;

import lombok.Getter;

@Getter
public class SendReservationConfirmationCommand {

    private final Long reservationId;
    private final Long userId;
    private final Long bookId;

    public SendReservationConfirmationCommand(Long reservationId, Long userId, Long bookId) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.bookId = bookId;
    }
}
