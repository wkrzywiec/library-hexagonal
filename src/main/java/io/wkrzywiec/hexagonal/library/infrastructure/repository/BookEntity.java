package io.wkrzywiec.hexagonal.library.infrastructure.repository;

import lombok.Builder;

import javax.persistence.*;

@Builder
@Entity
@Table(name="book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}
