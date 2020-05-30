package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingEventPublisher;

public class BorrowingEventPublisherFake implements BorrowingEventPublisher {

    @Override
    public void publish(BookReservedEvent event) {

    }
}
