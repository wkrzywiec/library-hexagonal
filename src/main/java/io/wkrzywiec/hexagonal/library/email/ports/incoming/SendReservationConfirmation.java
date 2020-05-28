package io.wkrzywiec.hexagonal.library.email.ports.incoming;

import io.wkrzywiec.hexagonal.library.email.model.SendReservationConfirmationCommand;

public interface SendReservationConfirmation {
    void handle(SendReservationConfirmationCommand reservationConfirmationCommand);
}
