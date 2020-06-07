package io.wkrzywiec.hexagonal.library.domain.inventory;

import io.restassured.response.ValidatableResponse;
import io.wkrzywiec.hexagonal.library.BookTestData;
import io.wkrzywiec.hexagonal.library.domain.BaseComponentTest;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.AddNewBookCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

public class AddNewBookComponentTest extends BaseComponentTest {

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

    @Test
    @DisplayName("Add new book to a database & make it available")
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenGoogleBooId_whenAddNewBook_thenBookIsSaved() {
        //given
        AddNewBookCommand addNewBookCommand =
                AddNewBookCommand.builder()
                        .googleBookId(BookTestData.homoDeusBookGoogleId())
                        .build();

        //when
        given()
                .contentType("application/json")
                .body(addNewBookCommand)
        .when()
                .post( baseURL + "/books")
                .prettyPeek()
        .then();

        //then
        Long savedBookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE book_external_id = ?",
                Long.class,
                BookTestData.homoDeusBookGoogleId());

        assertTrue(savedBookId > 0);

        Long availableBookId = jdbcTemplate.queryForObject(
                "SELECT id FROM available WHERE book_id = ?",
                Long.class,
                savedBookId);

        assertTrue(availableBookId > 0);
    }
}
