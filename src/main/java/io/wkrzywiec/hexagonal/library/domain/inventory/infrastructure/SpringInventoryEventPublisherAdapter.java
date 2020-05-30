package io.wkrzywiec.hexagonal.library.domain.inventory.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.NewBookWasAddedEvent;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing.InventoryEventPublisher;
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
