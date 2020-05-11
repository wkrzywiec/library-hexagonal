package io.wkrzywiec.hexagonal.library.domain;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookRepository;

import java.util.concurrent.ConcurrentHashMap;


public class InMemoryBookRepository implements BookRepository {

    private ConcurrentHashMap<Long, BookDTO> map = new ConcurrentHashMap<>();

    @Override
    public Long save(BookDTO bookDTO) {
        Long id = map.size() + 1L;
        map.put(id, bookDTO);
        return id;
    }

    @Override
    public BookDTO findById(Long id) {
        return map.get(id);
    }
}
