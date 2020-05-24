package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.inventory.InventoryFacade;
import io.wkrzywiec.hexagonal.library.inventory.infrastructure.BookRepository;
import io.wkrzywiec.hexagonal.library.inventory.infrastructure.GoogleBooksAdapter;
import io.wkrzywiec.hexagonal.library.inventory.infrastructure.InventoryDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.inventory.infrastructure.SpringInventoryEventPublisherAdapter;
import io.wkrzywiec.hexagonal.library.inventory.ports.incoming.AddNewBook;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class InventoryDomainConfig {

    @Bean
    SpringInventoryEventPublisherAdapter springInventoryEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new SpringInventoryEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    AddNewBook addNewBook(BookRepository repository, RestTemplate restTemplate, ApplicationEventPublisher applicationEventPublisher){
        return new InventoryFacade(
                new InventoryDatabaseAdapter(repository),
                new GoogleBooksAdapter(restTemplate),
                springInventoryEventPublisher(applicationEventPublisher));
    }
}
