package io.wkrzywiec.hexagonal.library.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.inventory.model.Book;

public interface GetBookDetails {
    Book handle(String bookId);
}
