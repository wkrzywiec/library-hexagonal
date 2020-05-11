package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.book.model.NewBookDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.outgoing.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostgresBookRepository implements BookRepository {

    private final BookSpringRepository repository;

    @Override
    public void save(NewBookDTO newBookDTO) {
        BookEntity bookEntity = BookEntity.builder().title(newBookDTO.getTitle()).build();
        repository.save(bookEntity);
    }
}
