package io.wkrzywiec.hexagonal.library.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.inventory.model.NewBookWasAddedEvent;

public interface EventPublisher {
    void publishNewBookWasAddedEvent(NewBookWasAddedEvent event);
}
