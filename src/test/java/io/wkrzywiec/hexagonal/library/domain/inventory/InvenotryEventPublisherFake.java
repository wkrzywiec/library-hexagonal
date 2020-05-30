package io.wkrzywiec.hexagonal.library.domain.inventory;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.NewBookWasAddedEvent;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing.InventoryEventPublisher;

public class InvenotryEventPublisherFake implements InventoryEventPublisher {

    @Override
    public void publishNewBookWasAddedEvent(NewBookWasAddedEvent event) { }
}
