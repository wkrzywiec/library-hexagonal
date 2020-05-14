package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.book.BookFacade;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.GetBookDetails;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookDatabase;
import io.wkrzywiec.hexagonal.library.infrastructure.adapter.BookDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.infrastructure.adapter.GoogleBooksAdapter;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.PostgresBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BookDomainConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    BookDatabase bookRepository(PostgresBookRepository repository){
        return new BookDatabaseAdapter(repository);
    }

    @Bean
    GetBookDetails getBookDetails(RestTemplate restTemplate){
        return new GoogleBooksAdapter(restTemplate);
    }

    @Bean
    AddNewBook addNewBook(BookDatabase database, GetBookDetails getBookDetails){
        return new BookFacade(database, getBookDetails);
    }
}
