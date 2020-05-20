package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.GetBookDetails;

import java.util.HashMap;
import java.util.Map;

public class GetBookDetailsFake implements GetBookDetails {

    private Map<String, Book> books;

    public GetBookDetailsFake() {
        books = new HashMap<String, Book>();
        books.put(
                TestData.homoDeusBookGoogleId(),
                TestData.homoDeusBook());
    }

    @Override
    public Book handle(String bookId) {
        return books.get(bookId);
    }
}
