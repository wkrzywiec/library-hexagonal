package io.wkrzywiec.hexagonal.library.domain.borrowing.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.MakeBookAvailableCommand;

public interface MakeBookAvailable {
    void handle(MakeBookAvailableCommand bookAvailableCommand);
}
