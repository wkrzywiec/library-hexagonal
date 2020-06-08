package io.wkrzywiec.hexagonal.library.domain.email.infrastructure;

import io.wkrzywiec.hexagonal.library.BookTestData;
import io.wkrzywiec.hexagonal.library.DatabaseHelper;
import io.wkrzywiec.hexagonal.library.UserTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
public class EmailDatabaseAdapterITCase {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private DatabaseHelper databaseHelper;
    private EmailDatabaseAdapter emailDatabase;

    @BeforeEach
    public void init(){
        emailDatabase = new EmailDatabaseAdapter(jdbcTemplate);
        databaseHelper = new DatabaseHelper(jdbcTemplate);
    }

    @Test
    @DisplayName("Get book title from db by its id")
    @Sql({"/book-and-user.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenBookId_whenGetBookTitle_thenGetBookTitle() {
        //given
        Long bookId = databaseHelper.getHomoDeusBookId();

        //when
        Optional<String> bookTitle = emailDatabase.getTitleByBookId(bookId);

        //then
        assertEquals(Optional.of(BookTestData.homoDeusBookTitle()), bookTitle);
    }

    @Test
    @DisplayName("Get empty result when book is not in db")
    @Sql({"/book-and-user.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenWrongBookId_whenGetBookTitle_thenGetEmptyResult() {
        //given
        Long bookId = databaseHelper.getHomoDeusBookId();

        //when
        Optional<String> bookTitle = emailDatabase.getTitleByBookId(bookId + 1124);

        //then
        assertEquals(Optional.empty(), bookTitle);
    }

    @Test
    @DisplayName("Get email from db by user id")
    @Sql({"/book-and-user.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenUserId_whenGetEmail_thenGetEmailAddress() {
        //given
        Long userId = databaseHelper.getJohnDoeUserId();

        //when
        Optional<String> emailAddress = emailDatabase.getUserEmailAddress(userId);

        //then
        assertEquals(Optional.of(UserTestData.johnDoeEmail()), emailAddress);
    }

    @Test
    @DisplayName("Get empty result when book is not in db")
    @Sql({"/book-and-user.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenWrongUserId_whenGetEmail_thenGetEmptyResult() {
        //given
        Long userId = databaseHelper.getJohnDoeUserId();

        //when
        Optional<String> emailAddress = emailDatabase.getUserEmailAddress(userId + 1124);

        //then
        assertEquals(Optional.empty(), emailAddress);
    }
}
