package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookReservationCommand {
    private Long bookId;
    private Long userId;
}
