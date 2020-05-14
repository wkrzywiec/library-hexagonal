package io.wkrzywiec.hexagonal.library.query;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.wkrzywiec.hexagonal.library.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class GoogleBookSearchClientITCase {

    private GoogleBookSearchClient client;
    private RestTemplate restTemplate;
    private MockRestServiceServer server;

    @BeforeEach
    public void init() {
        restTemplate = new RestTemplate();
        server = MockRestServiceServer.createServer(restTemplate);
        client = new GoogleBookSearchClient(restTemplate);
    }

    @Test
    @DisplayName("Search for a book")
    public void whenSearchForBooks_thenGetListOfBooks(){
        //given
        String harryPotterSearchResponse = TestData.harryPotterSearchResponse();
        server.expect(requestTo(
                "https://www.googleapis.com/books/v1/volumes?langRestrict=en&maxResults=40&printType=books&q=" + "harry%20potter"))
                .andRespond(withSuccess(harryPotterSearchResponse, MediaType.APPLICATION_JSON));

        String responseString = client.searchForBooks("harry potter");
        JsonObject response = JsonParser.parseString(responseString).getAsJsonObject();
        assertTrue(response.getAsJsonArray("items").size() == 4);
    }

    @Test
    @DisplayName("Search for a book and get empty result")
    public void whenSearchForBooks_thenGetEmptyResult(){
        //given
        String noBooksResponse = TestData.noBooksSearchResponse();
        server.expect(requestTo(
                "https://www.googleapis.com/books/v1/volumes?langRestrict=en&maxResults=40&printType=books&q=" + "djfjbasdknl"))
                .andRespond(withSuccess(noBooksResponse, MediaType.APPLICATION_JSON));

        //when
        String responseString = client.searchForBooks("djfjbasdknl");
        JsonObject response = JsonParser.parseString(responseString).getAsJsonObject();

        //then
        assertEquals(0, response.get("totalItems").getAsLong());
    }
}
