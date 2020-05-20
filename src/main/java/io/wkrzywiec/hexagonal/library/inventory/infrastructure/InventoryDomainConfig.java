package io.wkrzywiec.hexagonal.library.inventory.infrastructure;

import io.wkrzywiec.hexagonal.library.inventory.InventoryFacade;
import io.wkrzywiec.hexagonal.library.inventory.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.inventory.infrastructure.repository.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InventoryDomainConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    AddNewBook addNewBook(BookRepository repository, RestTemplate restTemplate){
        return new InventoryFacade(
                new InventoryDatabaseAdapter(repository),
                new GoogleBooksAdapter(restTemplate));
    }
}
