package io.wkrzywiec.hexagonal.library.borrowing.infrastructure;

import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringBorrowingEventPublisherAdapter implements BorrowingEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(BookReservedEvent event) {
        eventPublisher.publishEvent(event);
    }
}
