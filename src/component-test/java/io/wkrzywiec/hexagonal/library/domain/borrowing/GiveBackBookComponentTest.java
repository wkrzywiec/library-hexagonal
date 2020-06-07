package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.BookTestData;
import io.wkrzywiec.hexagonal.library.UserTestData;
import io.wkrzywiec.hexagonal.library.domain.BaseComponentTest;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.GiveBackBookCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

public class GiveBackBookComponentTest extends BaseComponentTest {

    @Test
    @DisplayName("Give back borrowed book")
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
                "INSERT INTO public.borrowed (book_id, user_id) VALUES (?, ?)",
                homoDeusBookId,
                activeUserId);

        GiveBackBookCommand giveBackBookCommand =
                GiveBackBookCommand.builder()
                        .bookId(homoDeusBookId )
                        .userId(activeUserId)
                        .build();

        //when
        given()
                .contentType("application/json")
                .body(giveBackBookCommand)
                .when()
                .post( baseURL + "/giveBack")
                .prettyPeek()
                .then();

        Long bookId = jdbcTemplate.queryForObject(
                "SELECT book_id FROM available WHERE book_id = ?",
                Long.class,
                homoDeusBookId);

        assertEquals(homoDeusBookId, bookId);
    }
}
