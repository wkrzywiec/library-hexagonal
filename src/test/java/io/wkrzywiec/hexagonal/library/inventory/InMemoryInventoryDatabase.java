package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryDatabase;

import java.util.concurrent.ConcurrentHashMap;


public class InMemoryInventoryDatabase implements InventoryDatabase {

    ConcurrentHashMap<Long, Book> books = new ConcurrentHashMap<>();

    @Override
    public void save(Book book) {
        Long id = books.size() + 1L;
        books.put(id, book);
    }
}
