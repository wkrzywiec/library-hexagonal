package io.wkrzywiec.hexagonal.library.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresBookRepository extends CrudRepository<BookEntity, Long> {
}
