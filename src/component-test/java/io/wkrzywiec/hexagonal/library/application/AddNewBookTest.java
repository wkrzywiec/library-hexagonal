package io.wkrzywiec.hexagonal.library.application;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddNewBookTest {

    @LocalServerPort
    private int port;

    private String baseURL;

    @BeforeEach
    public void init(){
        this.baseURL = "http://localhost:" + port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Search for a new book in Google Books")
    public void whenSearchForBook_thenGetList(){
        //when
        ValidatableResponse response = given()
                .when()
                    .param("query", "lean startup")
                .get( baseURL + "/google/books")
                    .prettyPeek()
                .then();

        //then
        response.statusCode(HttpStatus.OK.value())
                .contentType("application/json")
                .body("items.size()", greaterThan(0));

    }
}
