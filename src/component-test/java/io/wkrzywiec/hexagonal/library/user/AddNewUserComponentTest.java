package io.wkrzywiec.hexagonal.library.user;

import io.restassured.RestAssured;
import io.wkrzywiec.hexagonal.library.user.model.AddUserCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddNewUserComponentTest {

    @LocalServerPort
    private int port;

    private String baseURL;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void init(){
        baseURL = "http://localhost:" + port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

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
        Long savedUserId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                "john.doe@test.com");

        assertTrue(savedUserId > 0);
    }

}
