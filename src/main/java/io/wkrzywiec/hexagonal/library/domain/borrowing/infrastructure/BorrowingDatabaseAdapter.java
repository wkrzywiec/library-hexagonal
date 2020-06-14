package io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.entity.OverdueReservationEntity;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.DueDate;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.OverdueReservation;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservationId;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingDatabase;
import io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.mapper.BorrowedBookRowMapper;
import io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.mapper.ReservedBookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BorrowingDatabaseAdapter implements BorrowingDatabase {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(AvailableBook availableBook) {
        jdbcTemplate.update(
                "INSERT INTO available (book_id) VALUES (?)",
                availableBook.getIdAsLong());

        jdbcTemplate.update(
                "DELETE FROM reserved WHERE book_id = ?",
                availableBook.getIdAsLong());

        jdbcTemplate.update(
                "DELETE FROM borrowed WHERE book_id = ?",
                availableBook.getIdAsLong());
    }

    @Override
    public Optional<AvailableBook> getAvailableBook(Long bookId) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                    "SELECT book_id FROM available WHERE book_id = ?",
                    AvailableBook.class,
                            bookId));
        } catch (DataAccessException exception) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ActiveUser> getActiveUser(Long userId) {
        try {
            jdbcTemplate.queryForObject(
                            "SELECT id FROM public.library_user as u WHERE u.id = ?",
                            Long.class,
                            userId);
        } catch (DataAccessException exception) {
            return Optional.empty();
        }

        List<ReservedBook> reservedBooksByUser = getReservedBooksByUser(userId);
        List<BorrowedBook> borrowedBooksByUser = getBorrowedBooksByUser(userId);
        return Optional.of(new ActiveUser(userId, reservedBooksByUser, borrowedBooksByUser));
    }

    @Override
    public ReservationDetails save(ReservedBook reservedBook) {
       jdbcTemplate.update(
               "INSERT INTO reserved (book_id, user_id, reserved_date) VALUES (?, ?, ?)",
               reservedBook.getIdAsLong(),
               reservedBook.getAssignedUserIdAsLong(),
               Timestamp.from(reservedBook.getReservedDateAsInstant()));

        jdbcTemplate.update(
                "DELETE FROM available WHERE book_id = ?",
                reservedBook.getIdAsLong());

       ReservationId reservationId = jdbcTemplate.queryForObject(
               "SELECT id FROM reserved WHERE book_id = ?",
               ReservationId.class,
               reservedBook.getIdAsLong());
       return new ReservationDetails(reservationId, reservedBook);
    }

    @Override
    public void save(BorrowedBook borrowedBook) {
        jdbcTemplate.update(
                "INSERT INTO borrowed (book_id, user_id, borrowed_date) VALUES (?, ?, ?)",
                borrowedBook.getIdAsLong(),
                borrowedBook.getAssignedUserIdAsLong(),
                Timestamp.from(borrowedBook.getBorrowedDateAsInstant()));

        jdbcTemplate.update(
                "DELETE FROM reserved WHERE book_id = ?",
                borrowedBook.getIdAsLong());

        jdbcTemplate.update(
                "DELETE FROM available WHERE book_id = ?",
                borrowedBook.getIdAsLong());

    }

    @Override
    public List<OverdueReservation> findReservationsForMoreThan(Long days) {
        List<OverdueReservationEntity> entities = jdbcTemplate.query(
                "SELECT id AS reservationId, book_id AS bookIdentification FROM reserved WHERE DATEADD(day, ?, reserved_date) > NOW()",
                new BeanPropertyRowMapper<OverdueReservationEntity>(OverdueReservationEntity.class),
               days);
        return entities.stream()
                .map(entity -> new OverdueReservation(entity.getReservationId(), entity.getBookIdentification()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReservedBook> getReservedBook(Long bookId) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            "SELECT book_id, user_id, reserved_date FROM reserved WHERE book_id = ?",
                            new ReservedBookRowMapper(),
                            bookId));
        } catch (DataAccessException exception) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<BorrowedBook> getBorrowedBook(Long bookId) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            "SELECT book_id, user_id, borrowed_date FROM borrowed WHERE book_id = ?",
                            new BorrowedBookRowMapper(),
                            bookId));
        } catch (DataAccessException exception) {
            return Optional.empty();
        }
    }

    private List<ReservedBook> getReservedBooksByUser(Long userId) {
        try {
            return jdbcTemplate.query(
                    "SELECT book_id, user_id, reserved_date FROM reserved WHERE user_id = ?",
                    new ReservedBookRowMapper(),
                    userId
            );
        } catch (DataAccessException exception){
            return new ArrayList<>();
        }
    }

    private List<BorrowedBook> getBorrowedBooksByUser(Long userId) {
        try {
            return jdbcTemplate.query(
                    "SELECT book_id, user_id, borrowed_date FROM borrowed WHERE user_id = ?",
                    new BorrowedBookRowMapper(),
                    userId
            );
        } catch (DataAccessException exception){
            return new ArrayList<>();
        }
    }
}
