package io.wkrzywiec.hexagonal.library.user.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Embedded
    private EmailAddress emailAddress;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    public User(EmailAddress emailAddress, String firstName, String lastName) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getIdentifierAsLong(){
        return id;
    }

    private User(){}
}
