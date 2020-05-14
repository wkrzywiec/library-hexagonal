package io.wkrzywiec.hexagonal.library.domain.book.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.book.dto.ExternalBookIdDTO;

public interface AddNewBook {
    void handle(ExternalBookIdDTO externalBookIdDTO);
}
