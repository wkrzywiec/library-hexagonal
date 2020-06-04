package io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowBookCommand;

public interface BorrowBook {
    void handle(BorrowBookCommand borrowBookCommand);
}
