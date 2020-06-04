package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.restassured.RestAssured;
import io.wkrzywiec.hexagonal.library.BookTestData;
import io.wkrzywiec.hexagonal.library.UserTestData;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowBookCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
public class BorrowBookComponentTest {

    @LocalServerPort
    private int port;

    private String baseURL;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void init() {
        this.baseURL = "http://localhost:" + port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Disabled
    @DisplayName("Borrow reserved book")
    @Sql({"/book-and-user.sql", "/available-book.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenBookIsReserved_thenBorrowIt_thenBookIsBorrowed() {
        //given
        Long homoDeusBookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                BookTestData.homoDeusBookTitle());

        Long activeUserId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                UserTestData.johnDoeEmail());

        jdbcTemplate.update(
                "INSERT INTO public.reserved (book_id, user_id) VALUES (?, ?)",
                homoDeusBookId,
                activeUserId);

        BorrowBookCommand borrowBookCommand =
                BorrowBookCommand.builder()
                        .bookId(homoDeusBookId )
                        .userId(activeUserId)
                        .build();

        //when
        given()
                .contentType("application/json")
                .body(borrowBookCommand)
                .when()
                .post( baseURL + "/borrow")
                .prettyPeek()
                .then();

        Long reservationId = jdbcTemplate.queryForObject(
                "SELECT id FROM borrowed WHERE book_id = ?",
                Long.class,
                homoDeusBookId);

        assertTrue(reservationId > 0);
    }
}
