package io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDetailsDTO;

public interface BookDatabase {

    void save(BookDetailsDTO newBookDTO);
}
