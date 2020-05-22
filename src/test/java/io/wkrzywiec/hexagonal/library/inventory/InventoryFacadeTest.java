package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.inventory.model.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.GetBookDetails;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class InventoryFacadeTest {

    private GetBookDetails getBookDetails;
    private InMemoryInventoryDatabase database;
    private InventoryEventPublisher eventPublisher;
    private InventoryFacade facade;

    @BeforeEach
    public void init() {
        database = new InMemoryInventoryDatabase();
        getBookDetails = new GetBookDetailsFake();
        eventPublisher = new InvenotryEventPublisherFake();
        facade = new InventoryFacade(database, getBookDetails, eventPublisher);
    }

    @Test
    @DisplayName("Correctly save a new book in a repository")
    public void correctlySaveBook(){
        //given
        AddNewBookCommand externalBookId = AddNewBookCommand
                .builder()
                .googleBookId(TestData.homoDeusBookGoogleId())
                .build();

        //when
        facade.handle(externalBookId);

        //then
        Book actualBook = database.books.get(1L);
        assertNotNull(actualBook);
    }
}
