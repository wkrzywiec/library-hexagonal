package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.borrowing.BorrowingFacade;
import io.wkrzywiec.hexagonal.library.borrowing.infrastructure.BorrowingDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.borrowing.infrastructure.SpringBorrowingEventPublisherAdapter;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingDatabase;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
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
