package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.borrowing.BorrowingFacade;
import io.wkrzywiec.hexagonal.library.borrowing.infrastructure.BorrowingDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.borrowing.ports.incoming.MakeBookAvailable;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingDatabase;
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
    public MakeBookAvailable makeBookAvailable(BorrowingDatabase database) {
        return new BorrowingFacade(database);
    }
}
