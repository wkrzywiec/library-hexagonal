package io.wkrzywiec.hexagonal.library.borrowing.ports.incoming;

import io.wkrzywiec.hexagonal.library.borrowing.model.BookReservationCommand;

public interface ReserveBook {
    Long handle(BookReservationCommand bookReservation);
}
