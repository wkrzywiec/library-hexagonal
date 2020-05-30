package io.wkrzywiec.hexagonal.library.domain.inventory.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
