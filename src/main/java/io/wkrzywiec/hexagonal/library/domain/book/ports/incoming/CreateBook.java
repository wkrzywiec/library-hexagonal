package io.wkrzywiec.hexagonal.library.domain.book.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDTO;

public interface CreateBook {
    void createBook(BookDTO bookDTO);
}
