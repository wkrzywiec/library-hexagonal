package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.inventory.InventoryFacade;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.GetBookDetails;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.InventoryDatabase;
import io.wkrzywiec.hexagonal.library.infrastructure.adapter.InventoryDatabaseAdapter;
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
    InventoryDatabase bookRepository(PostgresBookRepository repository){
        return new InventoryDatabaseAdapter(repository);
    }

    @Bean
    GetBookDetails getBookDetails(RestTemplate restTemplate){
        return new GoogleBooksAdapter(restTemplate);
    }

    @Bean
    AddNewBook addNewBook(InventoryDatabase database, GetBookDetails getBookDetails){
        return new InventoryFacade(database, getBookDetails);
    }
}
