package io.wkrzywiec.hexagonal.library.domain.book.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;

public interface AddNewBook {
    void handle(NewBookDTO newBookDTO);
}
