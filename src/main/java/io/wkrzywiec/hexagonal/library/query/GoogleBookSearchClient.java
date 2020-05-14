package io.wkrzywiec.hexagonal.library.query;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Component
public class GoogleBookSearchClient {

    private final RestTemplate restTemplate;

    public String searchForBooks(String query){

        HttpHeaders requestHeader = new HttpHeaders();
        requestHeader.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeader);

        String searchQuery =
                "https://www.googleapis.com/books/v1/volumes?langRestrict=en&maxResults=40&printType=books&q=" + query.trim();

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(
                        searchQuery,
                        HttpMethod.GET,
                        requestEntity,
                        String.class);

        return responseEntity.getBody();
    }
}
