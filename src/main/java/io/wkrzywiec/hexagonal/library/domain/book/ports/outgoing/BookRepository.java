package io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;

public interface BookRepository {

    void save(NewBookDTO newBookDTO);
}
