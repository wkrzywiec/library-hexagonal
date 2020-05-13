package io.wkrzywiec.hexagonal.library.infrastructure.adapter;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.domain.book.model.BookDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class GoogleBooksAdapterTest {

    @Mock
    private RestTemplate restTemplate;

    private GoogleBooksAdapter adapter;

    @BeforeEach
    public void init() {
        Mockito.when(restTemplate.exchange(
                        eq("https://www.googleapis.com/books/v1/volumes/" + TestData.homoDeusBookDetailsDTO().getBookExternalId()),
                        eq(HttpMethod.GET),
                        any(),
                        eq(String.class)))
                .thenReturn(new ResponseEntity<>(TestData.homoDeusGooleBooksResponse(), HttpStatus.OK));
        adapter  = new GoogleBooksAdapter(restTemplate);
    }

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
