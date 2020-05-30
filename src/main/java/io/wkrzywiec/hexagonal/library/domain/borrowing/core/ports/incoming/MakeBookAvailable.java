package io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.MakeBookAvailableCommand;

public interface MakeBookAvailable {
    void handle(MakeBookAvailableCommand bookAvailableCommand);
}
