package io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;

public interface InventoryDatabase {
    void save(BookDetailsDTO newBookDTO);
}
