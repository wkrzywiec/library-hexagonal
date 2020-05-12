package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.book.BookFacade;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookDatabase;
import io.wkrzywiec.hexagonal.library.infrastructure.adapter.BookDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.PostgresBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookDomainConfig {

    @Bean
    BookDatabase bookRepository(PostgresBookRepository repository){
        return new BookDatabaseAdapter(repository);
    }

    @Bean
    AddNewBook addNewBook(BookDatabase repository){
        return new BookFacade(repository);
    }
}
