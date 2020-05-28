package io.wkrzywiec.hexagonal.library.email.application;

import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.email.model.SendReservationConfirmationCommand;
import io.wkrzywiec.hexagonal.library.email.ports.incoming.SendReservationConfirmation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookReservedEventHandler {

    private final SendReservationConfirmation sendReservationConfirmation;

    @EventListener
    public void handle(BookReservedEvent event) {
        sendReservationConfirmation.handle(
                new SendReservationConfirmationCommand(
                        event.getReservationIdAsLong(),
                        event.getUserIdAsLong(),
                        event.getBookIdAsLong()));
    }
}
