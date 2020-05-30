package io.wkrzywiec.hexagonal.library.domain.email.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailAddressTest {


    @Test
    @DisplayName("Create correct EmailAddress")
    public void givenCorrectEmailString_whenCreateEmailAddress_thenIsCreated(){
        //given
        String emailString = "john.doe@test.com";

        //when
        EmailAddress emailAddress = new EmailAddress(emailString);

        //then
        assertEquals(emailString, emailAddress.getAsString());
    }

    @Test
    @DisplayName("Throw IllegalArgument exception for incorrect email")
    public void givenInCorrectEmailString_whenCreateEmailAddress_thenThrowException(){
        //given
        String notAnEmailString = "not an email";
        String emailWithoutAt = "tom[at]test.com";
        String emailWithoutDomain = "tom@";

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmailAddress(notAnEmailString));

        assertThrows(
                IllegalArgumentException.class,
                () -> new EmailAddress(emailWithoutAt));

        assertThrows(
                IllegalArgumentException.class,
                () -> new EmailAddress(emailWithoutDomain));
    }
}
