package io.wkrzywiec.hexagonal.library.domain.borrowing.application;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.MakeBookAvailableCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.NewBookWasAddedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NewBookWasAddedEventHandler {

    @Qualifier("MakeBookAvailable")
    private final MakeBookAvailable makeBookAvailable;

    @EventListener
    public void handle(NewBookWasAddedEvent event){
        makeBookAvailable.handle(new MakeBookAvailableCommand(event.getBookIdAsLong()));
    }
}
