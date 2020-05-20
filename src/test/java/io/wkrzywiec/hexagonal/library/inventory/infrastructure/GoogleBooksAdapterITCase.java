package io.wkrzywiec.hexagonal.library.inventory.infrastructure;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class GoogleBooksAdapterITCase {

    private GoogleBooksAdapter googleBooks;
    private RestTemplate restTemplate;
    private MockRestServiceServer server;


    @BeforeEach
    public void init() {
        restTemplate = new RestTemplate();
        server = MockRestServiceServer.createServer(restTemplate);
        googleBooks = new GoogleBooksAdapter(restTemplate);
    }

    @Test
    @DisplayName("Get book details from Google Books")
    public void givenCorrectBookId_whenGetBookDetails_thenReturnBookDetailsDTO(){
        //given
        String homoDeusResponse = TestData.homoDeusGooleBooksResponse();
        Book homoDeusBook = TestData.homoDeusBook();
        server.expect(requestTo(
                "https://www.googleapis.com/books/v1/volumes/" + TestData.homoDeusBookGoogleId()))
                .andRespond(withSuccess(homoDeusResponse, MediaType.APPLICATION_JSON));

        //when
        Book actualBook= googleBooks.handle(TestData.homoDeusBookGoogleId());

        //then
        assertEquals(homoDeusBook, actualBook);
    }
}
