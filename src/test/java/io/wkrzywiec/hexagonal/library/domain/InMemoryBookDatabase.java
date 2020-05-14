package io.wkrzywiec.hexagonal.library.domain;

import io.wkrzywiec.hexagonal.library.domain.book.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookDatabase;

import java.util.concurrent.ConcurrentHashMap;


public class InMemoryBookDatabase implements BookDatabase {

    ConcurrentHashMap<Long, BookDetailsDTO> books = new ConcurrentHashMap<>();

    @Override
    public void save(BookDetailsDTO newBookDTO) {
        Long id = books.size() + 1L;
        books.put(id, newBookDTO);
    }
}
