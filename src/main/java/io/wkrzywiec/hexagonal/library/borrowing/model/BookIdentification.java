package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookIdentification {
    private final Long value;

    public Long getValueAsLong(){
        return value;
    }
}
