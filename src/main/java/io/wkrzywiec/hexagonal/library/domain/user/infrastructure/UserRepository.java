package io.wkrzywiec.hexagonal.library.domain.user.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.user.core.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
