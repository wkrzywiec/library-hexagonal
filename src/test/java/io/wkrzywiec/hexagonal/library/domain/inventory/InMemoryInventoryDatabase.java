package io.wkrzywiec.hexagonal.library.domain.inventory;

import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.InventoryDatabase;

import java.util.concurrent.ConcurrentHashMap;


public class InMemoryInventoryDatabase implements InventoryDatabase {

    ConcurrentHashMap<Long, BookDetailsDTO> books = new ConcurrentHashMap<>();

    @Override
    public void save(BookDetailsDTO newBookDTO) {
        Long id = books.size() + 1L;
        books.put(id, newBookDTO);
    }
}
