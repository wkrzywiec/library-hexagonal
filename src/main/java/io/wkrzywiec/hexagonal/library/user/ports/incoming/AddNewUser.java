package io.wkrzywiec.hexagonal.library.user.ports.incoming;

import io.wkrzywiec.hexagonal.library.user.model.AddUserCommand;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;

public interface AddNewUser {
    UserIdentifier handle(AddUserCommand addUserCommand);
}
