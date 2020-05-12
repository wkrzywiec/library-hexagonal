package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDetailsDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleBooksAdapterTest {

    GoogleBooksAdapter adapter = new GoogleBooksAdapter();

    @Test
    @DisplayName("Get book details from Google Books")
    public void givenCorrectBookId_whenGetBookDetails_thenReturnBookDetailsDTO(){
        //given
        String googleBookId = "dWYyCwAAQBAJ";

        //when
        BookDetailsDTO bookDetails = adapter.handle(googleBookId);

        //then
        BookDetailsDTO expectedDetails = BookDetailsDTO.builder()
                .bookExternalId(googleBookId)
                .isbn10("1473545374")
                .isbn13("9781473545373")
                .title("Homo Deus")
                .authors(Collections.singletonList("Yuval Noah Harari"))
                .publisher("Random House")
                .publishedDate("2016-09-08")
                .description("<p><b>**THE MILLION COPY BESTSELLER**</b><br> <b></b><br><b> <i>Sapiens </i>showed us where we came from. In uncertain times, <i>Homo Deus</i> shows us where we’re going.</b></p><p> Yuval Noah Harari envisions a near future in which we face a new set of challenges. <i>Homo Deus</i> explores the projects, dreams and nightmares that will shape the twenty-first century and beyond – from overcoming death to creating artificial life.</p><p> It asks the fundamental questions: how can we protect this fragile world from our own destructive power? And what does our future hold?<br> <b></b><br><b> '<i>Homo Deus</i> will shock you. It will entertain you. It will make you think in ways you had not thought before’ Daniel Kahneman, bestselling author of <i>Thinking, Fast and Slow</i></b></p>")
                .pages(528)
                .build();

        assertEquals(expectedDetails, bookDetails);
    }
}
