package io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;

import java.util.Optional;

public interface BorrowingDatabase {
    Optional<AvailableBook> getAvailableBook(Long bookId);
    Optional<ActiveUser> getActiveUser(Long userId);
    void saveReservationFor(ActiveUser activeUser);
}
