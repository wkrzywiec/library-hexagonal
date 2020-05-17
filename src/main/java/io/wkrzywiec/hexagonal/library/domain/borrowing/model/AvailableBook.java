package io.wkrzywiec.hexagonal.library.domain.borrowing.model;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class AvailableBook implements Book {

    private Long id;

    public AvailableBook(Long id) {
        this.id = id;
    }

    public ReservedBook reserve(){
        return new ReservedBook(id);
    }
}
