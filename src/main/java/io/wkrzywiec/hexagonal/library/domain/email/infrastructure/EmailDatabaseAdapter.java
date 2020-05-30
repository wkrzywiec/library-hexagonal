package io.wkrzywiec.hexagonal.library.domain.email.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing.EmailDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

@RequiredArgsConstructor
public class EmailDatabaseAdapter implements EmailDatabase {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<String> getTitleByBookId(Long bookId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT title FROM book WHERE id = ?",
                    String.class,
                    bookId));
        } catch (DataAccessException ex){
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> getUserEmailAddress(Long userId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT email FROM user WHERE id = ?",
                    String.class,
                    userId));
        } catch (DataAccessException ex){
            return Optional.empty();
        }
    }
}
