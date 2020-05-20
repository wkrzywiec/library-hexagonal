package io.wkrzywiec.hexagonal.library.infrastructure.adapter;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ReservedBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@JdbcTest
public class BorrowingDatabaseAdapterITCase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BorrowingDatabaseAdapter database;

    @BeforeEach
    public void init(){
        database = new BorrowingDatabaseAdapter(jdbcTemplate);

        jdbcTemplate.update(
                "INSERT INTO book (book_external_id, title) VALUES (?, ?)",
                TestData.homoDeusBookDetailsDTO().getBookExternalId(),
                TestData.homoDeusBookDetailsDTO().getTitle());

        jdbcTemplate.update(
                "INSERT INTO user (first_name, last_name, email) VALUES (?, ?, ?)",
                "John",
                "Doe",
                "john.doe@test.com");
    }

    @Test
    @DisplayName("Save book as available")
    public void shouldSaveAvailableBook(){
        //given
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                TestData.homoDeusBookDetailsDTO().getTitle());

        //when
        database.setBookAvailable(bookId);

        //then
        Long savedBookId = jdbcTemplate.queryForObject(
                "SELECT book_id FROM available WHERE book_id = ?",
                Long.class,
                bookId);
        assertEquals(bookId, savedBookId);
    }

    @Test
    @DisplayName("Get available book by id")
    public void shouldGetAvailableBook(){
        //given
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                TestData.homoDeusBookDetailsDTO().getTitle());

        jdbcTemplate.update(
                "INSERT INTO available (book_id) VALUES (?)",
                bookId);

        //when
        Optional<AvailableBook> availableBookOptional = database.getAvailableBook(bookId);

        //then
        assertTrue(availableBookOptional.isPresent());
        assertEquals(bookId, availableBookOptional.get().getIdAsLong());
    }

    @Test
    @DisplayName("Get active user by id")
    public void shouldGetActiveUser() {
        //given
        Long activeUserId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                "john.doe@test.com");

        //when
        Optional<ActiveUser> activeUserOptional = database.getActiveUser(activeUserId);

        //then
        assertTrue(activeUserOptional.isPresent());
        assertEquals(activeUserId, activeUserOptional.get().getIdAsLong());
    }

    @Test
    @DisplayName("Save reserved book")
    public void shouldSaveReservedBook(){
        //given
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                TestData.homoDeusBookDetailsDTO().getTitle());

        Long activeUserId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                "john.doe@test.com");

        ReservedBook reservedBook = new ReservedBook(bookId, activeUserId);

        //when
        database.save(reservedBook);

        //then
        Map<String, Object> reservationDetails =
                jdbcTemplate.queryForMap(
                        "SELECT book_id, user_id FROM reserved WHERE book_id = ?", bookId);


        assertEquals(bookId, reservationDetails.get("book_id"));
        assertEquals(activeUserId, reservationDetails.get("user_id"));
    }
}