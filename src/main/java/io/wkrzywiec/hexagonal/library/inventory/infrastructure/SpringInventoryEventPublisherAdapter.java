package io.wkrzywiec.hexagonal.library.inventory.infrastructure;

import io.wkrzywiec.hexagonal.library.inventory.model.NewBookWasAddedEvent;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class SpringInventoryEventPublisherAdapter implements InventoryEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishNewBookWasAddedEvent(NewBookWasAddedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
