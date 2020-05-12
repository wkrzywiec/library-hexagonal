package io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;

public interface BookDatabase {

    void save(NewBookDTO newBookDTO);
}
