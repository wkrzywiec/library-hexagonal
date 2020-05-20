package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ReservationId {
    private final Long id;

    public ReservationId(Long id) {
        this.id = id;
    }

    public Long getIdAsLong(){
        return id;
    }
}
