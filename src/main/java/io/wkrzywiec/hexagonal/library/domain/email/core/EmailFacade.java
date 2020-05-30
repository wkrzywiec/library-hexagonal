package io.wkrzywiec.hexagonal.library.domain.email.core;

import io.wkrzywiec.hexagonal.library.domain.email.core.model.ReservationConfirmEmail;
import io.wkrzywiec.hexagonal.library.domain.email.core.model.SendReservationConfirmationCommand;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.incoming.SendReservationConfirmation;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing.EmailSender;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing.EmailDatabase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailFacade implements SendReservationConfirmation {

    private final EmailSender emailSender;
    private final EmailDatabase database;

    @Override
    public void handle(SendReservationConfirmationCommand sendReservationConfirmation) {
        String bookTitle = database
                .getTitleByBookId(sendReservationConfirmation.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Can't get book title from database. Reason: there is no book with an id: " + sendReservationConfirmation.getBookId()));
        String userEmailAddress = database
                .getUserEmailAddress(sendReservationConfirmation.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Can't get email address from database. Reason: there is no user with an id: " + sendReservationConfirmation.getUserId()));

        ReservationConfirmEmail reservationConfirmEmail = EmailCreator.reservationEmail(
                sendReservationConfirmation.getReservationId(),
                bookTitle,
                userEmailAddress
        );
        emailSender.sendReservationConfirmationEmail(reservationConfirmEmail);
    }
}
