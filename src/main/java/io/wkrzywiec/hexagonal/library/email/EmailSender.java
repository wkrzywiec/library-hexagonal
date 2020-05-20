package io.wkrzywiec.hexagonal.library.email;

import io.wkrzywiec.hexagonal.library.borrowing.model.ReservationDetails;

public interface EmailSender {
    void sendReservationConfirmationEmail(ReservationDetails reservationDetails);
}
