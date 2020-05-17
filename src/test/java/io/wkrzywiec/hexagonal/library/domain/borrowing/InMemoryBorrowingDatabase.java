package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing.BorrowingDatabase;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBorrowingDatabase implements BorrowingDatabase {

    ConcurrentHashMap<Long, AvailableBook> availableBooks = new ConcurrentHashMap<>();
    ConcurrentHashMap<Long, ActiveUser> activeUsers = new ConcurrentHashMap<>();

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
    public void saveReservationFor(ActiveUser activeUser) {
        activeUsers.replace(activeUser.getId(), activeUser);
    }
}
