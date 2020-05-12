package io.wkrzywiec.hexagonal.library.query;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GoogleBooksClientTest {

    @Autowired
    private GoogleBooksClient client;

    @Test
    @DisplayName("Search for a book in Google Books API")
    public void whenSearchForBooks_thenGetListOfBooks(){

        String responseString = client.searchForBooks("harry potter");
        JsonObject response = JsonParser.parseString(responseString).getAsJsonObject();
        assertTrue(response.getAsJsonArray("items").size() > 0);
    }

    @Test
    @DisplayName("Search for a book in Google Book API and get empty result")
    public void whenSearchForBooks_thenGetEmptyResult(){
        String responseString = client.searchForBooks("djfjbasdknl");
        JsonObject response = JsonParser.parseString(responseString).getAsJsonObject();
        assertEquals(0, response.get("totalItems").getAsLong());
    }
}
