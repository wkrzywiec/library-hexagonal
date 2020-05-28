package io.wkrzywiec.hexagonal.library.user;

import io.wkrzywiec.hexagonal.library.user.model.AddUserCommand;
import io.wkrzywiec.hexagonal.library.user.model.EmailAddress;
import io.wkrzywiec.hexagonal.library.user.model.NewUser;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserFacadeTest {

    private InMemoryUserDatabase database;
    private UserFacade facade;

    @BeforeEach
    public void init(){
        database = new InMemoryUserDatabase();
        facade = new UserFacade(database);
    }

    @Test
    @DisplayName("Add new user")
    public void shouldAddNewUser(){
        //given
        NewUser expectedNewUser = new NewUser(
                new EmailAddress("john.doe@test.com"),
                "John",
                "Doe"
        );

        AddUserCommand addUserCommand = AddUserCommand.builder()
                .email("john.doe@test.com")
                .firstName("John")
                .lastName("Doe")
                .build();

        //when
        UserIdentifier userIdentifier = facade.handle(addUserCommand);

        //then
        assertTrue(userIdentifier.getAsLong() > 0);
        assertEquals(expectedNewUser, database.users.get(userIdentifier.getAsLong()));
    }
}
