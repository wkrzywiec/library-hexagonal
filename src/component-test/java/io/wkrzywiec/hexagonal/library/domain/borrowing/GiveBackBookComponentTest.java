package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.BaseComponentTest;
import io.wkrzywiec.hexagonal.library.domain.borrowing.application.model.BookStatus;
import io.wkrzywiec.hexagonal.library.domain.borrowing.application.model.ChangeBookStatusRequest;
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

        ChangeBookStatusRequest giveBackRequest =
                ChangeBookStatusRequest.builder()
                        .userId(activeUserId)
                        .status(BookStatus.AVAILABLE)
                        .build();

        //when
        given()
                .contentType("application/json")
                .body(giveBackRequest)
                .when()
                .patch( baseURL + "/books/" + homoDeusBookId + "/status")
                .prettyPeek()
                .then();

        Long bookId = databaseHelper.getPrimaryKeyOfAvailableByBookBy(homoDeusBookId);

        assertEquals(homoDeusBookId, bookId);
    }
}
