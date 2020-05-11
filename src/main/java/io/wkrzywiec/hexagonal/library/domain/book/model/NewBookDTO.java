package io.wkrzywiec.hexagonal.library.domain.book.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NewBookDTO {

    String title;
}
