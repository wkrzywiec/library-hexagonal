package io.wkrzywiec.hexagonal.library.domain.user.core;

import io.wkrzywiec.hexagonal.library.domain.user.core.model.AddUserCommand;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.EmailAddress;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.User;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.UserIdentifier;
import io.wkrzywiec.hexagonal.library.domain.user.core.ports.incoming.AddNewUser;
import io.wkrzywiec.hexagonal.library.domain.user.core.ports.outgoing.UserDatabase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFacade implements AddNewUser {

    private final UserDatabase database;

    @Override
    public UserIdentifier handle(AddUserCommand addUserCommand) {
        User user = new User(
                new EmailAddress(addUserCommand.getEmail()),
                addUserCommand.getFirstName(),
                addUserCommand.getLastName()
        );
        return database.save(user);
    }
}
