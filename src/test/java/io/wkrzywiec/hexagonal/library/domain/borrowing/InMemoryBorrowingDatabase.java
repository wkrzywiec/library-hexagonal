package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ReservationId;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ReservedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing.BorrowingDatabase;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBorrowingDatabase implements BorrowingDatabase {

    ConcurrentHashMap<Long, ActiveUser> activeUsers = new ConcurrentHashMap<>();
    ConcurrentHashMap<Long, AvailableBook> availableBooks = new ConcurrentHashMap<>();
    ConcurrentHashMap<Long, ReservedBook> reservedBooks = new ConcurrentHashMap<>();

    @Override
    public void setBookAvailable(Long bookId) {
        availableBooks.put(bookId, new AvailableBook(bookId));
    }

    @Override
    public Optional<AvailableBook> getAvailableBook(Long bookId) {
        if (availableBooks.containsKey(bookId)) {
            return Optional.of(availableBooks.get(bookId));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ActiveUser> getActiveUser(Long userId) {
        if (activeUsers.containsKey(userId)) {
            return Optional.of(activeUsers.get(userId));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public ReservationDetails save(ReservedBook reservedBook) {
        Long reservationId = new Random().nextLong();
        availableBooks.remove(reservedBook.getIdAsLong());
        reservedBooks.put(reservationId,  reservedBook);
        return new ReservationDetails(new ReservationId(reservationId), reservedBook);
    }
}
