package io.wkrzywiec.hexagonal.library.infrastructure.adapter;

import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookDatabase;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.BookEntity;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.PostgresBookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookDatabaseAdapter implements BookDatabase {

    private final PostgresBookRepository repository;

    @Override
    public void save(NewBookDTO newBookDTO) {
        BookEntity bookEntity = BookEntity.builder().title(newBookDTO.getTitle()).build();
        repository.save(bookEntity);
    }
}
