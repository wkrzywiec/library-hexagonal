package io.wkrzywiec.hexagonal.library.domain.borrowing.model;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class ReservedBook implements Book {

    private Long id;

    public ReservedBook(Long id) {
        this.id = id;
    }

}
