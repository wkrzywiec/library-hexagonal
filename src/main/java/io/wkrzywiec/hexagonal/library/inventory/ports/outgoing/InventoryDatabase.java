package io.wkrzywiec.hexagonal.library.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.inventory.model.BookDetailsDTO;

public interface InventoryDatabase {
    //TODO change to entity model
    void save(BookDetailsDTO newBookDTO);
}
