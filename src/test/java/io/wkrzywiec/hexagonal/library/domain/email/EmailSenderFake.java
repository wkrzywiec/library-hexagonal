package io.wkrzywiec.hexagonal.library.domain.email;

import io.wkrzywiec.hexagonal.library.domain.email.core.model.ReservationConfirmEmail;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing.EmailSender;

public class EmailSenderFake implements EmailSender {

    @Override
    public void sendReservationConfirmationEmail(ReservationConfirmEmail reservationConfirmEmail) {

    }
}
