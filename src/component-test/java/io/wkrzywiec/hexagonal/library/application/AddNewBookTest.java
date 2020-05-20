package io.wkrzywiec.hexagonal.library.application;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.domain.inventory.dto.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.BookEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddNewBookTest {

    @LocalServerPort
    private int port;

    @Autowired
    private JdbcTemplate jdbc;

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

    @Test
    @DisplayName("Add new book to a database")
    public void givenGoogleBooId_whenAddNewBook_thenBookIsSaved(){
        //given
        BookDetailsDTO homoDeusBookDetails = TestData.homoDeusBookDetailsDTO();
        AddNewBookCommand addNewBookCommand =
                AddNewBookCommand.builder()
                        .googleBookId(homoDeusBookDetails.getBookExternalId())
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
        String homoDeusSql = "select * from book where book_external_id = '" + homoDeusBookDetails.getBookExternalId() + "'";
        BookEntity savedBook = (BookEntity) jdbc.queryForObject(homoDeusSql, new BeanPropertyRowMapper(BookEntity.class));
        assertEquals(homoDeusBookDetails.getBookExternalId(), savedBook.getBookExternalId());
        assertEquals(homoDeusBookDetails.getTitle(), savedBook.getTitle());
    }
}
