package io.wkrzywiec.hexagonal.library.domain.email.core.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.email.core.model.SendReservationConfirmationCommand;

public interface SendReservationConfirmation {
    void handle(SendReservationConfirmationCommand reservationConfirmationCommand);
}
