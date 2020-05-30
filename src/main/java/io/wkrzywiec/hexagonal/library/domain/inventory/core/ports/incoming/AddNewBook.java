package io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.AddNewBookCommand;

public interface AddNewBook {
    void handle(AddNewBookCommand addNewBookCommand);
}
