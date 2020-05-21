package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
public class MakeBookAvailableCommand {
    private Long bookId;
}
