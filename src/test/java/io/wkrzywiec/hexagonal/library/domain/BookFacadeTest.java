package io.wkrzywiec.hexagonal.library.domain;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.domain.book.BookFacade;
import io.wkrzywiec.hexagonal.library.domain.book.model.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.book.model.ExternalBookIdDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.GetBookDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookFacadeTest {

    private GetBookDetails getBookDetails;
    private InMemoryBookDatabase database;
    private BookFacade facade;

    @BeforeEach
    public void init() {
        database = new InMemoryBookDatabase();
        getBookDetails = new GetBookDetailsMock();
        facade = new BookFacade(database, getBookDetails);
    }

    @Test
    @DisplayName("Correctly save a new book in a repository")
    public void correctlySaveBook(){
        //given
        BookDetailsDTO expectedBook = TestData.homoDeusBookDetailsDTO();
        ExternalBookIdDTO externalBookId = ExternalBookIdDTO
                .builder()
                .value(expectedBook.getBookExternalId())
                .build();

        //when
        facade.handle(externalBookId);

        //then
        BookDetailsDTO actualBook = database.books.get(1L);
        assertEquals(expectedBook, actualBook);
    }
}
