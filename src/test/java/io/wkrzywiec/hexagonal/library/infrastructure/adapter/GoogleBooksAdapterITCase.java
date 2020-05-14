package io.wkrzywiec.hexagonal.library.infrastructure.adapter;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.domain.book.dto.BookDetailsDTO;
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
        BookDetailsDTO homoDeusBookDetails = TestData.homoDeusBookDetailsDTO();
        server.expect(requestTo(
                "https://www.googleapis.com/books/v1/volumes/" + homoDeusBookDetails.getBookExternalId()))
                .andRespond(withSuccess(homoDeusResponse, MediaType.APPLICATION_JSON));

        //when
        BookDetailsDTO actualBookDetails = googleBooks.handle(homoDeusBookDetails.getBookExternalId());

        //then
        assertEquals(homoDeusBookDetails, actualBookDetails);
    }
}
