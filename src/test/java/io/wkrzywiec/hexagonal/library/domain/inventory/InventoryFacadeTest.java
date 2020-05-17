package io.wkrzywiec.hexagonal.library.domain.inventory;

import io.wkrzywiec.hexagonal.library.InventoryTestData;
import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.inventory.dto.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.GetBookDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryFacadeTest {

    private GetBookDetails getBookDetails;
    private InMemoryInventoryDatabase database;
    private InventoryFacade facade;

    @BeforeEach
    public void init() {
        database = new InMemoryInventoryDatabase();
        getBookDetails = new GetBookDetailsFake();
        facade = new InventoryFacade(database, getBookDetails);
    }

    @Test
    @DisplayName("Correctly save a new book in a repository")
    public void correctlySaveBook(){
        //given
        BookDetailsDTO expectedBook = InventoryTestData.homoDeusBookDetailsDTO();
        AddNewBookCommand externalBookId = AddNewBookCommand
                .builder()
                .googleBookId(expectedBook.getBookExternalId())
                .build();

        //when
        facade.handle(externalBookId);

        //then
        BookDetailsDTO actualBook = database.books.get(1L);
        assertEquals(expectedBook, actualBook);
    }
}
