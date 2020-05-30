package io.wkrzywiec.hexagonal.library.domain.user.core.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.user.core.model.User;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.UserIdentifier;

public interface UserDatabase {
    UserIdentifier save(User user);
}
