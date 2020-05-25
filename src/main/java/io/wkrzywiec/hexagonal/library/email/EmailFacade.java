package io.wkrzywiec.hexagonal.library.email;

import io.wkrzywiec.hexagonal.library.email.model.Email;
import io.wkrzywiec.hexagonal.library.email.model.SendReservationConfirmationCommand;
import io.wkrzywiec.hexagonal.library.email.ports.incoming.SendReservationConfirmation;
import io.wkrzywiec.hexagonal.library.email.ports.outgoing.EmailSender;
import io.wkrzywiec.hexagonal.library.email.ports.outgoing.LibraryDatabase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailFacade implements SendReservationConfirmation {

    private final EmailSender emailSender;
    private final LibraryDatabase database;

    @Override
    public void handle(SendReservationConfirmationCommand sendReservationConfirmation) {
        String bookTitle = database
                .getTitleByBookId(sendReservationConfirmation.getBookId());
        String userEmailAddress = database
                .getUserEmailAddress(sendReservationConfirmation.getUserId());

        Email email = EmailCreator.reservationEmail(
                sendReservationConfirmation.getReservationId(),
                bookTitle,
                userEmailAddress
        );
        emailSender.sendReservationConfirmationEmail(email);
    }
}
