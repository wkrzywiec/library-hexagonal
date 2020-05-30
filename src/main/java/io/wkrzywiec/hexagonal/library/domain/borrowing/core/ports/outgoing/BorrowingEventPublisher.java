package io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservedEvent;

public interface BorrowingEventPublisher {
    public void publish(BookReservedEvent event);
}
