package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.inventory.model.NewBookWasAddedEvent;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryEventPublisher;

public class InvenotryEventPublisherFake implements InventoryEventPublisher {

    @Override
    public void publishNewBookWasAddedEvent(NewBookWasAddedEvent event) { }
}
