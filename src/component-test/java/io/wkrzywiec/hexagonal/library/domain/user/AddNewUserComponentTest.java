package io.wkrzywiec.hexagonal.library.domain.user;

import io.wkrzywiec.hexagonal.library.domain.BaseComponentTest;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.AddUserCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

public class AddNewUserComponentTest extends BaseComponentTest {

    @Test
    @DisplayName("Create new user")
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void shouldCreateNewUser(){
        //given
        AddUserCommand addUserCommand = AddUserCommand.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@test.com")
                .build();

        //when
        given()
                .contentType("application/json")
                .body(addUserCommand)
        .when()
                .post( baseURL + "/users")
                .prettyPeek()
        .then();

        //then
        Long savedUserId = databaseHelper.getJohnDoeUserId();
        assertTrue(savedUserId > 0);
    }

}
