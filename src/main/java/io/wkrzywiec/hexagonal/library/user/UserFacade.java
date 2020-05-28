package io.wkrzywiec.hexagonal.library.user;

import io.wkrzywiec.hexagonal.library.user.model.AddUserCommand;
import io.wkrzywiec.hexagonal.library.user.model.EmailAddress;
import io.wkrzywiec.hexagonal.library.user.model.NewUser;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;
import io.wkrzywiec.hexagonal.library.user.ports.incoming.AddNewUser;
import io.wkrzywiec.hexagonal.library.user.ports.outgoing.UserDatabase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFacade implements AddNewUser {

    private final UserDatabase database;

    @Override
    public UserIdentifier handle(AddUserCommand addUserCommand) {
        NewUser newUser = new NewUser(
                new EmailAddress(addUserCommand.getEmail()),
                addUserCommand.getFirstName(),
                addUserCommand.getLastName()
        );
        return database.save(newUser);
    }
}
