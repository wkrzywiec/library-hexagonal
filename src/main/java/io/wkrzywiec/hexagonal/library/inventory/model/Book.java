package io.wkrzywiec.hexagonal.library.inventory.model;

import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name="book")
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private BookIdentification identification;

    @Column(name="title")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name="book_author",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="author_id"))
    private Set<Author> authors;

    @Column(name="publisher")
    private String publisher;

    @Column(name="publishedDate")
    private String publishedDate;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    @Column(name="page_count")
    private int pages;

    @Column(name="imageLink", columnDefinition="TEXT")
    @EqualsAndHashCode.Exclude
    private String imageLink;

    public Book(BookIdentification identification, String title, Set<Author> authors, String publisher, String publishedDate, String description, int pages, String imageLink) {
        this.identification = identification;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pages = pages;
        this.imageLink = imageLink;
    }

    public Long getIdAsLong(){
        return id;
    }

    private Book() {
    }
}
