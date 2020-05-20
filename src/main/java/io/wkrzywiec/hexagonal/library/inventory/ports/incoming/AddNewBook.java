package io.wkrzywiec.hexagonal.library.inventory.ports.incoming;

import io.wkrzywiec.hexagonal.library.inventory.model.AddNewBookCommand;

public interface AddNewBook {
    void handle(AddNewBookCommand addNewBookCommand);
}
