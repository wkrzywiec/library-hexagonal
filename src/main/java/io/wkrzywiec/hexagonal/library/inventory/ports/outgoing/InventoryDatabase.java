package io.wkrzywiec.hexagonal.library.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.inventory.dto.BookDetailsDTO;

public interface InventoryDatabase {
    void save(BookDetailsDTO newBookDTO);
}
