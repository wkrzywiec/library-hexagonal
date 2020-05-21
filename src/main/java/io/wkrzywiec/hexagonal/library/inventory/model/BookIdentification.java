package io.wkrzywiec.hexagonal.library.inventory.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@EqualsAndHashCode
public class BookIdentification {

    @Column(name="book_external_id")
    private String bookExternalId;

    @Embedded
    private Isbn10 isbn10;

    @Embedded
    private Isbn13 isbn13;

    public BookIdentification(String bookExternalId, Isbn10 isbn10, Isbn13 isbn13) {
        this.bookExternalId = bookExternalId;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
    }

    private BookIdentification() {
    }
}
