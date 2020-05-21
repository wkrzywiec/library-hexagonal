package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BookReservationCommand {
    private Long bookId;
    private Long userId;
}
