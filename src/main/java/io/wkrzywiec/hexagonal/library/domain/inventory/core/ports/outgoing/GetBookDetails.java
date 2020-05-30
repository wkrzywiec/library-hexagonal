package io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.Book;

public interface GetBookDetails {
    Book handle(String bookId);
}
