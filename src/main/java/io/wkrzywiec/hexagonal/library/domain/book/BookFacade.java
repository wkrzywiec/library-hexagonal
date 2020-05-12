package io.wkrzywiec.hexagonal.library.domain.book;

import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookDatabase;

public class BookFacade implements AddNewBook {

    private BookDatabase database;

    public BookFacade(BookDatabase database) {
        this.database = database;
    }

    @Override
    public void handle(NewBookDTO newBookDTO){
        database.save(newBookDTO);
    }
}
