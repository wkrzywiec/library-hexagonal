package io.wkrzywiec.hexagonal.library.user.infrastructure;

import io.wkrzywiec.hexagonal.library.user.model.User;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;
import io.wkrzywiec.hexagonal.library.user.ports.outgoing.UserDatabase;
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
