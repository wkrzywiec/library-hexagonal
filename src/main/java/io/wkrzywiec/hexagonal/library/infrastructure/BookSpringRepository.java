package io.wkrzywiec.hexagonal.library.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSpringRepository extends CrudRepository<BookEntity, Long> {
}
