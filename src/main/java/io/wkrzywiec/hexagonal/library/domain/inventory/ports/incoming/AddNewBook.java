package io.wkrzywiec.hexagonal.library.domain.inventory.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.inventory.dto.AddNewBookCommand;

public interface AddNewBook {
    void handle(AddNewBookCommand addNewBookCommand);
}
