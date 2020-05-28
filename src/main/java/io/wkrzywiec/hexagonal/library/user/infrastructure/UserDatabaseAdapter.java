package io.wkrzywiec.hexagonal.library.user.infrastructure;

import io.wkrzywiec.hexagonal.library.user.model.NewUser;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;
import io.wkrzywiec.hexagonal.library.user.ports.outgoing.UserDatabase;

public class UserDatabaseAdapter implements UserDatabase {

    @Override
    public UserIdentifier save(NewUser newUser) {
        return null;
    }
}
