package io.wkrzywiec.hexagonal.library.domain.book;

import io.wkrzywiec.hexagonal.library.domain.book.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.book.dto.ExternalBookIdDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.GetBookDetails;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookDatabase;

public class BookFacade implements AddNewBook {

    private BookDatabase database;
    private GetBookDetails getBookDetails;

    public BookFacade(BookDatabase database, GetBookDetails getBookDetails) {
        this.database = database;
        this.getBookDetails = getBookDetails;
    }

    @Override
    public void handle(ExternalBookIdDTO externalBookIdDTO){
        BookDetailsDTO bookDetails = getBookDetails.handle(externalBookIdDTO.getValue());
        database.save(bookDetails);
    }
}
