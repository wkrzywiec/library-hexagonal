package io.wkrzywiec.hexagonal.library.domain.borrowing.core.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class AvailableBook implements Book {

    private final Long id;

    public AvailableBook(Long id) {
        this.id = id;
    }

    @Override
    public Long getIdAsLong() {
        return id;
    }
}
