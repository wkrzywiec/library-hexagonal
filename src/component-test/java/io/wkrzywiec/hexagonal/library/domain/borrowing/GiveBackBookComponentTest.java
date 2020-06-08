package io.wkrzywiec.hexagonal.library.domain.borrowing;

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
    @Sql({"/book-and-user.sql", "/borrowed-book.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenBookIsBorrowed_thenGiveBackIt_thenItIsAvailable() {
        //given
        Long homoDeusBookId = databaseHelper.getHomoDeusBookId();
        Long activeUserId = databaseHelper.getJohnDoeUserId();

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

        Long bookId = databaseHelper.getPrimaryKeyOfAvailableByBookBy(homoDeusBookId);

        assertEquals(homoDeusBookId, bookId);
    }
}
