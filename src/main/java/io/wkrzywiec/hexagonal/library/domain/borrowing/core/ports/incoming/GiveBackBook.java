package io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.GiveBackBookCommand;

public interface GiveBackBook {
    void handle(GiveBackBookCommand command);
}
