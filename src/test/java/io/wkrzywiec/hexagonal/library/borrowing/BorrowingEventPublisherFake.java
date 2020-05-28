package io.wkrzywiec.hexagonal.library.borrowing;

import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingEventPublisher;

public class BorrowingEventPublisherFake implements BorrowingEventPublisher {

    @Override
    public void publish(BookReservedEvent event) {

    }
}
