package io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.NewBookWasAddedEvent;

public interface InventoryEventPublisher {
    void publishNewBookWasAddedEvent(NewBookWasAddedEvent event);
}
