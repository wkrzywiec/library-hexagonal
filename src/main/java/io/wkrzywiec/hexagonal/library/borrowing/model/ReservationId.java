package io.wkrzywiec.hexagonal.library.borrowing.model;

import lombok.EqualsAndHashCode;

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
