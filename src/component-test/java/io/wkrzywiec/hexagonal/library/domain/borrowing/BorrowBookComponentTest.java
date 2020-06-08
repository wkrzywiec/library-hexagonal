package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.BookTestData;
import io.wkrzywiec.hexagonal.library.UserTestData;
import io.wkrzywiec.hexagonal.library.domain.BaseComponentTest;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowBookCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

public class BorrowBookComponentTest extends BaseComponentTest {

    @Test
    @DisplayName("Borrow reserved book")
    @Sql({"/book-and-user.sql", "/reserved-book.sql"})
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

        Long borrowId = jdbcTemplate.queryForObject(
                "SELECT id FROM borrowed WHERE book_id = ?",
                Long.class,
                homoDeusBookId);

        assertTrue(borrowId > 0);
    }
}
