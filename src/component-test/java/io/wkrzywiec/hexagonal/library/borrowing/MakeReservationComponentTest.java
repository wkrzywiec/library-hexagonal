package io.wkrzywiec.hexagonal.library.borrowing;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.inventory.infrastructure.BookRepository;
import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        Book book = bookRepository.save(TestData.homoDeusBook());
        jdbcTemplate.update(
                "INSERT INTO available (book_id) VALUES (?)",
                book.getIdAsLong());

        jdbcTemplate.update(
                "INSERT INTO user (first_name, last_name, email) VALUES (?, ?, ?)",
                "John",
                "Doe",
                "john.doe@test.com");
    }

    @Test
    @DisplayName("Reserve available book")
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
