package io.wkrzywiec.hexagonal.library.inventory.ports.outgoing;

import io.wkrzywiec.hexagonal.library.inventory.model.Book;

public interface InventoryDatabase {
    Book save(Book book);
}
