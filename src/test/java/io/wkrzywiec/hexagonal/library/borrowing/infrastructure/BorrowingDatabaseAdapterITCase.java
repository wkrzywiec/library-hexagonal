package io.wkrzywiec.hexagonal.library.borrowing.infrastructure;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservedBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
public class BorrowingDatabaseAdapterITCase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BorrowingDatabaseAdapter database;

    @BeforeEach
    public void init(){
        database = new BorrowingDatabaseAdapter(jdbcTemplate);
    }

    @Test
    @DisplayName("Save book as available")
    @Sql("/book-and-user.sql")
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void shouldSaveAvailableBook(){
        //given
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                TestData.homoDeusBookTitle());

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
    @Sql({"/book-and-user.sql", "/available-book.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void shouldGetAvailableBook(){
        //given
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                TestData.homoDeusBookTitle());

        //when
        Optional<AvailableBook> availableBookOptional = database.getAvailableBook(bookId);

        //then
        assertTrue(availableBookOptional.isPresent());
        assertEquals(bookId, availableBookOptional.get().getIdAsLong());
    }

    @Test
    @DisplayName("Get active user by id")
    @Sql("/book-and-user.sql")
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
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
    @Sql({"/book-and-user.sql", "/available-book.sql"})
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void shouldSaveReservedBook(){
        //given
        Long bookId = jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                TestData.homoDeusBookTitle());

        Long activeUserId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                "john.doe@test.com");

        ReservedBook reservedBook = new ReservedBook(bookId, activeUserId);

        //when
        ReservationDetails reservationDetails = database.save(reservedBook);

        //then
        assertEquals(bookId, reservationDetails.getReservedBook().getIdAsLong());
        assertEquals(activeUserId, reservationDetails.getReservedBook().getAssignedUserIdAsLong());
        assertTrue(reservationDetails.getReservationId().getIdAsLong() > 0);
    }
}