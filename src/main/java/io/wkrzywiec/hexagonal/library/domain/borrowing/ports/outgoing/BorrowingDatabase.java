package io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ReservedBook;

import java.util.Optional;

public interface BorrowingDatabase {
    void setBookAvailable(Long bookId);
    Optional<AvailableBook> getAvailableBook(Long bookId);
    Optional<ActiveUser> getActiveUser(Long userId);
    void save(ReservedBook reservedBook);
}
