package io.wkrzywiec.hexagonal.library;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class DatabaseHelper {

    private final JdbcTemplate jdbcTemplate;

    public Long getHomoDeusBookId(){
        return jdbcTemplate.queryForObject(
                "SELECT id FROM book WHERE title = ?",
                Long.class,
                BookTestData.homoDeusBookTitle());
    }

    public Long getJohnDoeUserId(){
        return jdbcTemplate.queryForObject(
                "SELECT id FROM library_user WHERE email = ?",
                Long.class,
                UserTestData.johnDoeEmail());
    }

    public Long getPrimaryKeyOfAvailableByBookBy(Long bookId){
        return jdbcTemplate.queryForObject(
                "SELECT book_id FROM available WHERE book_id = ?",
                Long.class,
                bookId);
    }

    public Long getPrimaryKeyOfReservationByBookId(Long bookId){
        return jdbcTemplate.queryForObject(
                "SELECT id FROM reserved WHERE book_id = ?",
                Long.class,
                bookId);
    }

    public Long getPrimaryKeyOfBorrowedByBookId(Long bookId){
        return jdbcTemplate.queryForObject(
                "SELECT book_id FROM borrowed WHERE book_id = ?",
                Long.class,
                bookId);
    }
}
