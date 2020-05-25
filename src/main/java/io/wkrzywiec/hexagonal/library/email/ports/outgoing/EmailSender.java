package io.wkrzywiec.hexagonal.library.email.ports.outgoing;


import io.wkrzywiec.hexagonal.library.email.model.Email;

public interface EmailSender {
    void sendReservationConfirmationEmail(Email email);
}
