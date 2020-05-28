package io.wkrzywiec.hexagonal.library.email.ports.outgoing;


import io.wkrzywiec.hexagonal.library.email.model.ReservationConfirmEmail;

public interface EmailSender {
    void sendReservationConfirmationEmail(ReservationConfirmEmail reservationConfirmEmail);
}
