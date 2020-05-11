package io.wkrzywiec.hexagonal.library.domain.book;

import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookRepository;

public class BookFacade implements AddNewBook {

    private BookRepository repository;

    public BookFacade(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(NewBookDTO newBookDTO){
        repository.save(newBookDTO);
    }
}
