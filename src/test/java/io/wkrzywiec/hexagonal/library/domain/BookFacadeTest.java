package io.wkrzywiec.hexagonal.library.domain;

import io.wkrzywiec.hexagonal.library.domain.book.BookFacade;
import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookFacadeTest {

    private InMemoryBookRepository repository = new InMemoryBookRepository();
    private BookFacade facade = new BookFacade(repository);

    @Test
    @DisplayName("Correctly save a new book in a repository")
    public void correctlySaveBook(){
        NewBookDTO newBook = NewBookDTO.builder()
                .title("Harry Potter and the Philosopher's Stone")
                .build();

        facade.handle(newBook);

        NewBookDTO actualBook = repository.books.get(1L);
        assertEquals(newBook, actualBook);
    }
}
