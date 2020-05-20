package io.wkrzywiec.hexagonal.library.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.inventory.model.BookDetailsDTO;

public interface GetBookDetails {
    BookDetailsDTO handle(String bookId);
}
