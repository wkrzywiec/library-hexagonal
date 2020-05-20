package io.wkrzywiec.hexagonal.library.inventory.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsbnTest {

    @Test
    @DisplayName("ISBN-10 is created correctly")
    public void shouldCreateCorrectISBN10(){
        assertEquals("1473545374", new Isbn10("1473545374").getAsString());
    }

    @Test
    @DisplayName("ISBN-10 is not created")
    public void shouldNotCreateCorrectISBN10(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Isbn10("9781473545373").getAsString()
        );
    }

    @Test
    @DisplayName("ISBN-13 is created correctly")
    public void shouldCreateCorrectISBN13(){
        assertEquals("9781473545373", new Isbn13("9781473545373").getAsString());
    }

    @Test
    @DisplayName("ISBN-13 is not created")
    public void shouldNotCreateCorrectISBN13(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Isbn13("1473545374").getAsString()
        );
    }
}
