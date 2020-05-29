package io.wkrzywiec.hexagonal.library.email.infrastructure;

import io.wkrzywiec.hexagonal.library.BookTestData;
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

    private EmailDatabaseAdapter emailDatabase;

    @BeforeEach
    public void init(){
        emailDatabase = new EmailDatabaseAdapter(jdbcTemplate);
    }

    @Test
    @DisplayName("Get book title from db by its id")
    @Sql({"/book-and-user.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void givenBookId_whenGetBookTitle_thenGetBookTitle() {
        //given
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                BookTestData.homoDeusBookTitle());

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
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                BookTestData.homoDeusBookTitle());

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
        Long userId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                UserTestData.johnDoeEmail());

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
        Long userId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                UserTestData.johnDoeEmail());

        //when
        Optional<String> emailAddress = emailDatabase.getUserEmailAddress(userId + 1124);

        //then
        assertEquals(Optional.empty(), emailAddress);
    }
}
