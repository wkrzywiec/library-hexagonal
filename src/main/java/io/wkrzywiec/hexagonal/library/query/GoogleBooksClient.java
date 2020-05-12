package io.wkrzywiec.hexagonal.library.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class GoogleBooksClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public String searchForBooks(String query){
        return restTemplate.getForObject("https://www.googleapis.com/books/v1/volumes?langRestrict=en&maxResults=40&printType=books&q=" + query, String.class);
    }
}
