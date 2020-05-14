package io.wkrzywiec.hexagonal.library.domain.book.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.book.dto.BookDetailsDTO;

public interface GetBookDetails {
    BookDetailsDTO handle(String bookId);
}
