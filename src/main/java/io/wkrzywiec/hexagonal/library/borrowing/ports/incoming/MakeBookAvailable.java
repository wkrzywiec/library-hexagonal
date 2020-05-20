package io.wkrzywiec.hexagonal.library.borrowing.ports.incoming;

import io.wkrzywiec.hexagonal.library.borrowing.model.MakeBookAvailableCommand;

public interface MakeBookAvailable {
    void handle(MakeBookAvailableCommand bookAvailableCommand);
}
