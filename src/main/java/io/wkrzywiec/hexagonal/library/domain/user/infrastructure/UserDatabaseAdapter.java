package io.wkrzywiec.hexagonal.library.domain.user.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.user.core.model.User;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.UserIdentifier;
import io.wkrzywiec.hexagonal.library.domain.user.core.ports.outgoing.UserDatabase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDatabaseAdapter implements UserDatabase {

    private final UserRepository userRepository;

    @Override
    public UserIdentifier save(User user) {
        User savedUser = userRepository.save(user);
        return new UserIdentifier(savedUser.getIdentifierAsLong());
    }
}
