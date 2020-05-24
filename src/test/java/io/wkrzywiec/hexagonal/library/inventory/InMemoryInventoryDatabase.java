package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryDatabase;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.concurrent.ConcurrentHashMap;


public class InMemoryInventoryDatabase implements InventoryDatabase {

    ConcurrentHashMap<Long, Book> books = new ConcurrentHashMap<>();

    @Override
    public Book save(Book book) {
        Long id = books.size() + 1L;

        try {
            FieldUtils.writeField(book, "id", id, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        books.put(id, book);
        return book;
    }
}
