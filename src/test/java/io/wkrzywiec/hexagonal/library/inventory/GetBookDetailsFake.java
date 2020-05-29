package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.BookTestData;
import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.GetBookDetails;

import java.util.HashMap;
import java.util.Map;

public class GetBookDetailsFake implements GetBookDetails {

    private Map<String, Book> books;

    public GetBookDetailsFake() {
        books = new HashMap<String, Book>();
        books.put(
                BookTestData.homoDeusBookGoogleId(),
                BookTestData.homoDeusBook());
    }

    @Override
    public Book handle(String bookId) {
        return books.get(bookId);
    }
}
