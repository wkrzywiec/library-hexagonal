package io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservationCommand;

public interface ReserveBook {
    Long handle(BookReservationCommand bookReservation);
}
