package io.wkrzywiec.hexagonal.library.inventory.infrastructure;

import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryDatabase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class InventoryDatabaseAdapter implements InventoryDatabase {

    private final BookRepository repository;

    @Override
    public void save(Book book) {
        repository.save(book);
    }
}
