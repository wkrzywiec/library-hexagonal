package io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing;


import io.wkrzywiec.hexagonal.library.domain.email.core.model.ReservationConfirmEmail;

public interface EmailSender {
    void sendReservationConfirmationEmail(ReservationConfirmEmail reservationConfirmEmail);
}
