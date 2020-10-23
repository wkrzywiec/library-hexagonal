package io.wkrzywiec.hexagonal.library.domain.borrowing.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class BookReservationCommand {
    private Long bookId;
    private Long userId;
}
