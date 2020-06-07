package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.BorrowingFacade;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.BorrowBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.CancelOverdueReservations;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.GiveBackBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.ReserveBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingDatabase;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingEventPublisher;
import io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.BorrowingDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.SpringBorrowingEventPublisherAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("MakeBookAvailable")
    public MakeBookAvailable makeBookAvailable(BorrowingDatabase database, BorrowingEventPublisher borrowingEventPublisher) {
        return new BorrowingFacade(database, borrowingEventPublisher);
    }

    @Bean
    @Qualifier("ReserveBook")
    public ReserveBook reserveBook(BorrowingDatabase database, BorrowingEventPublisher borrowingEventPublisher){
        return new BorrowingFacade(database, borrowingEventPublisher);
    }

    @Bean
    @Qualifier("BorrowBook")
    public BorrowBook borrowBook(BorrowingDatabase database, BorrowingEventPublisher borrowingEventPublisher){
        return new BorrowingFacade(database, borrowingEventPublisher);
    }

    @Bean
    @Qualifier("GiveBackBook")
    public GiveBackBook giveBackBook(BorrowingDatabase database, BorrowingEventPublisher borrowingEventPublisher){
        return new BorrowingFacade(database, borrowingEventPublisher);
    }

    @Bean
    @Qualifier("CancelOverdueReservations")
    public CancelOverdueReservations cancelOverdueReservations(BorrowingDatabase database, BorrowingEventPublisher borrowingEventPublisher){
        return new BorrowingFacade(database, borrowingEventPublisher);
    }
}
