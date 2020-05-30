package io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservedEvent;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingEventPublisher;
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
