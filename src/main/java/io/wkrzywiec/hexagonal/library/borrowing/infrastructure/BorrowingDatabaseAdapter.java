package io.wkrzywiec.hexagonal.library.borrowing.infrastructure;

import io.wkrzywiec.hexagonal.library.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservationId;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservedBook;
import io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing.BorrowingDatabase;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BorrowingDatabaseAdapter implements BorrowingDatabase {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setBookAvailable(Long bookId) {
        jdbcTemplate.update(
                "INSERT INTO available (book_id) VALUES (?)",
                bookId);
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
            boolean isActiveUserAvailable = Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            "SELECT id FROM public.user as u WHERE u.id = ?",
                            Long.class,
                            userId)).isPresent();

            if (isActiveUserAvailable){
                List<ReservedBook> reservedBooksByUser =
                    jdbcTemplate.queryForList(
                            "SELECT book_id FROM reserved WHERE reserved.user_id = ?",
                            ReservedBook.class,
                            userId
                    );
                return Optional.of(
                        new ActiveUser(userId, reservedBooksByUser)
                );
            } else {
                return Optional.empty();
            }
        } catch (DataAccessException exception) {
            return Optional.empty();
        }
    }

    @Override
    public ReservationDetails save(ReservedBook reservedBook) {
       jdbcTemplate.update(
               "INSERT INTO reserved (book_id, user_id) VALUES (?, ?)",
               reservedBook.getIdAsLong(),
               reservedBook.getAssignedUserIdAsLong());

       ReservationId reservationId = jdbcTemplate.queryForObject(
               "SELECT id FROM reserved WHERE book_id = ?",
               ReservationId.class,
               reservedBook.getIdAsLong());
       return new ReservationDetails(reservationId, reservedBook);
    }
}
