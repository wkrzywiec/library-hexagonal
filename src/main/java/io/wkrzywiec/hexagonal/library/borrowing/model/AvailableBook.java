package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
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
