package io.wkrzywiec.hexagonal.library.domain.email.application;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.domain.email.core.model.SendReservationConfirmationCommand;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.incoming.SendReservationConfirmation;
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
