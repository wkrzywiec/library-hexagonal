package io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing;

import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservedEvent;

public interface BorrowingEventPublisher {
    public void publish(BookReservedEvent event);
}
