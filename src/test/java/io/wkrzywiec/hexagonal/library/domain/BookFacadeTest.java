package io.wkrzywiec.hexagonal.library.domain;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.domain.book.BookFacade;
import io.wkrzywiec.hexagonal.library.domain.book.model.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.book.model.ExternalBookIdDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.GetBookDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookFacadeTest {

    @Mock
    private GetBookDetails getBookDetails;
    private InMemoryBookDatabase database;
    private BookFacade facade;

    @BeforeEach
    public void init() {
        database = new InMemoryBookDatabase();
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

        when(
                getBookDetails.handle(expectedBook.getBookExternalId()))
                .thenReturn(expectedBook);

        //when
        facade.handle(externalBookId);

        //then
        BookDetailsDTO actualBook = database.books.get(1L);
        assertEquals(expectedBook, actualBook);
    }
}
