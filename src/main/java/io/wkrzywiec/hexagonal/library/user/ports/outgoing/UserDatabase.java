package io.wkrzywiec.hexagonal.library.user.ports.outgoing;

import io.wkrzywiec.hexagonal.library.user.model.User;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;

public interface UserDatabase {
    UserIdentifier save(User user);
}
