package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.BorrowingFacade;
import io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.BorrowingDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.SpringBorrowingEventPublisherAdapter;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingDatabase;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class BorrowingDomainConfig {

    @Bean
    public BorrowingDatabase borrowingDatabase(JdbcTemplate jdbcTemplate) {
        return new BorrowingDatabaseAdapter(jdbcTemplate);
    }

    @Bean
    public BorrowingEventPublisher borrowingEventPublisher(ApplicationEventPublisher applicationEventPublisher){
        return new SpringBorrowingEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public MakeBookAvailable makeBookAvailable(BorrowingDatabase database, BorrowingEventPublisher borrowingEventPublisher) {
        return new BorrowingFacade(database, borrowingEventPublisher);
    }
}
