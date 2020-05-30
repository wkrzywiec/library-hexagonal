package io.wkrzywiec.hexagonal.library.domain.user.core.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.user.core.model.AddUserCommand;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.UserIdentifier;

public interface AddNewUser {
    UserIdentifier handle(AddUserCommand addUserCommand);
}
