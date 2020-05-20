package io.wkrzywiec.hexagonal.library.inventory.ports.incoming;

import io.wkrzywiec.hexagonal.library.inventory.dto.AddNewBookCommand;

public interface AddNewBook {
    void handle(AddNewBookCommand addNewBookCommand);
}
