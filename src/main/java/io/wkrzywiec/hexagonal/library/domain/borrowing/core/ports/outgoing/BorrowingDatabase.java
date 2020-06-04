package io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowedBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.DueDate;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.OverdueReservation;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservedBook;

import java.util.List;
import java.util.Optional;

public interface BorrowingDatabase {
    void setBookAvailable(Long bookId);
    Optional<AvailableBook> getAvailableBook(Long bookId);
    Optional<ActiveUser> getActiveUser(Long userId);
    ReservationDetails save(ReservedBook reservedBook);
    void save(BorrowedBook borrowedBook);
    List<OverdueReservation> findReservationsAfter(DueDate dueDate);
    Optional<ReservedBook> getReservedBook(Long bookId);
}
