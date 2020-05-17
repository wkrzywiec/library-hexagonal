package io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ReservedBook;

public interface EmailSender {
    void sendReservationConfirmationEmail(ActiveUser activeUser, ReservedBook reservedBook);
}
