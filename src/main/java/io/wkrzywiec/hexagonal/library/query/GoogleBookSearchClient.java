package io.wkrzywiec.hexagonal.library.query;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
@Component
public class GoogleBookSearchClient {

    public String searchForBooks(String query){
        Response response =
                given()
                        .param("q", query)
                        .when()
                .get("https://www.googleapis.com/books/v1/volumes?langRestrict=en&maxResults=40&printType=books");
        return response.getBody().asString();
    }
}
