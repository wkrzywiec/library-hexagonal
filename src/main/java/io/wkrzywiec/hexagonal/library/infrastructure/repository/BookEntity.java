package io.wkrzywiec.hexagonal.library.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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


@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_external_id")
    private String bookExternalId;

    @Column(name="isbn_10")
    private String isbn10;

    @Column(name="isbn_13")
    private String isbn13;

    @Column(name="title")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name="book_author",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="author_id"))
    private Set<AuthorEntiy> authors;

    @Column(name="publisher")
    private String publisher;

    @Column(name="publishedDate")
    private String publishedDate;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    @Column(name="pages")
    private int pages;

    @Column(name="imageLink", columnDefinition="TEXT")
    private String imageLink;
}
