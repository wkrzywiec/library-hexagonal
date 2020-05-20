package io.wkrzywiec.hexagonal.library.inventory.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
@EqualsAndHashCode
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", unique=true)
    private String name;

    public Author(String name) {
        this.name = name;
    }

    private Author() {
    }
}
