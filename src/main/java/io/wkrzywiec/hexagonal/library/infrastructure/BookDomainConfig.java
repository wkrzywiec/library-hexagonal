package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.book.BookFacade;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookDomainConfig {

    @Bean
    BookRepository bookRepository(BookSpringRepository repository){
        return new PostgresBookRepository(repository);
    }

    @Bean
    AddNewBook addNewBook(BookRepository repository){
        return new BookFacade(repository);
    }
}
