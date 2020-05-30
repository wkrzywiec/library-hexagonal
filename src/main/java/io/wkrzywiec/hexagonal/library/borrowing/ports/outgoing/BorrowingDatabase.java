package io.wkrzywiec.hexagonal.library.borrowing.ports.outgoing;

import io.wkrzywiec.hexagonal.library.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.borrowing.model.MaxReservationInterval;
import io.wkrzywiec.hexagonal.library.borrowing.model.OverdueReservation;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservationDetails;
import io.wkrzywiec.hexagonal.library.borrowing.model.ReservedBook;

import java.util.List;
import java.util.Optional;

public interface BorrowingDatabase {
    void setBookAvailable(Long bookId);
    Optional<AvailableBook> getAvailableBook(Long bookId);
    Optional<ActiveUser> getActiveUser(Long userId);
    ReservationDetails save(ReservedBook reservedBook);
    List<OverdueReservation> findReservationsAfter(MaxReservationInterval maxReservationInterval);
}
