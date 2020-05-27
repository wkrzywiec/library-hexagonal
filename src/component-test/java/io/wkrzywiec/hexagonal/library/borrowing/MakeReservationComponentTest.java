package io.wkrzywiec.hexagonal.library.borrowing;

import io.restassured.RestAssured;
import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.inventory.infrastructure.BookRepository;
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
public class MakeReservationComponentTest {

    @LocalServerPort
    private int port;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String baseURL;

    @BeforeEach
    public void init() {
        this.baseURL = "http://localhost:" + port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Reserve available book")
    @Sql({"/book-and-user.sql", "/available-book.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenBookIsAvailable_thenMakeReservation_thenBookIsReserved() {
        //given
        Long homoDeusBookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                TestData.homoDeusBookTitle());

        Long activeUserId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                "john.doe@test.com");

        BookReservationCommand reservationCommand =
                BookReservationCommand.builder()
                .bookId(homoDeusBookId )
                .userId(activeUserId)
                .build();

        //when
        given()
                .contentType("application/json")
                .body(reservationCommand)
        .when()
                .post( baseURL + "/reservations")
                .prettyPeek()
        .then();

        Long reservationId = jdbcTemplate.queryForObject(
                "SELECT id FROM reserved WHERE book_id = ?",
                Long.class,
                homoDeusBookId);

        assertTrue(reservationId > 0);
    }
}
