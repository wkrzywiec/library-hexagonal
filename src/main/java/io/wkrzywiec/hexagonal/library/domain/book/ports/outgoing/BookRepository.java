package io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDTO;

public interface BookRepository {

    Long save(BookDTO bookDTO);
    BookDTO findById(Long id);
}
