package io.wkrzywiec.hexagonal.library.domain.borrowing.application.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangeBookStatusRequest {

    private BookStatus status;
    private Long userId;
}
