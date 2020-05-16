package io.wkrzywiec.hexagonal.library.domain.inventory.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class BookDetailsDTO {

    private String bookExternalId;
    private String isbn10;
    private String isbn13;
    private String title;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private int pages;
    @EqualsAndHashCode.Exclude
    private String imageLink;
}
