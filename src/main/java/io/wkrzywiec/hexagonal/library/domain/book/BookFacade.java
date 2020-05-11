package io.wkrzywiec.hexagonal.library.domain.book;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.CreateBook;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookRepository;

public class BookFacade implements CreateBook {

    private BookRepository repository;

    public BookFacade(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createBook(BookDTO book){
        repository.save(book);
    }
}
