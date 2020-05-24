package io.wkrzywiec.hexagonal.library.borrowing.application;

import io.wkrzywiec.hexagonal.library.borrowing.model.MakeBookAvailableCommand;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.inventory.model.NewBookWasAddedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class NewBookWasAddedEventHandler {

    private MakeBookAvailable makeBookAvailable;

    @EventListener
    public void handle(NewBookWasAddedEvent event){
        makeBookAvailable.handle(new MakeBookAvailableCommand(event.getBookIdAsLong()));
    }
}
