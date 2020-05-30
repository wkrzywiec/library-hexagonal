package io.wkrzywiec.hexagonal.library.domain.inventory.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.Book;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing.InventoryDatabase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InventoryDatabaseAdapter implements InventoryDatabase {

    private final BookRepository repository;

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
