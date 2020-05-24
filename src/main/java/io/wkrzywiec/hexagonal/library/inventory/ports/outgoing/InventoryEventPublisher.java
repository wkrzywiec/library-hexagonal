package io.wkrzywiec.hexagonal.library.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.inventory.model.NewBookWasAddedEvent;

public interface InventoryEventPublisher {
    void publishNewBookWasAddedEvent(NewBookWasAddedEvent event);
}
