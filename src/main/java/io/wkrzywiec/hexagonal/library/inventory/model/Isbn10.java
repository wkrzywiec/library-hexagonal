package io.wkrzywiec.hexagonal.library.inventory.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
public class Isbn10 {
    @Column(name="isbn_10")
    private String value;

    public Isbn10(String value) {
        if (value.matches("\\d{10}")){
            this.value = value;
        } else {
            throw new IllegalArgumentException("ISBN-10 should have 10 digits only.");
        }
    }

    private Isbn10() {
    }

    public String getAsString(){
        return value;
    }
}
