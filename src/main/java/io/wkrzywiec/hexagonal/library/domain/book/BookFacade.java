package io.wkrzywiec.hexagonal.library.domain.book;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookRepository;

public class BookFacade {

    private BookRepository repository;

    public BookFacade(BookRepository repository) {
        this.repository = repository;
    }

    public void createNewBook(BookDTO book){
        repository.save(book);
    }
}
