package io.wkrzywiec.hexagonal.library.domain;

import io.wkrzywiec.hexagonal.library.domain.book.BookFacade;
import io.wkrzywiec.hexagonal.library.domain.book.model.BookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookFacadeTest {

    private BookRepository repository = new InMemoryBookRepository();
    private BookFacade facade = new BookFacade(repository);

    @Test
    @DisplayName("Correctly save a new book in a repository")
    public void correctlySaveBook(){
        BookDTO book = BookDTO.builder()
                .title("Harry Potter and the Philosopher's Stone")
                .build();

        facade.createNewBook(book);

        BookDTO actualBook = repository.findById(1L);
        assertEquals(book, actualBook);
    }
}
