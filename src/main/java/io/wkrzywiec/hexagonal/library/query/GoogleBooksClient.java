package io.wkrzywiec.hexagonal.library.query;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
@Component
public class GoogleBooksClient {

    public String searchForBooks(String query){
        Response response =
                given()
                        .param("q", query)
                        .when()
                .get("https://www.googleapis.com/books/v1/volumes?langRestrict=en&maxResults=40&printType=books");
        return response.getBody().asString();
    }

    public String getBookById(String bookId) {
        Response response =
                given()
                        .pathParam("bookId", bookId)
                        .when()
                .get("https://www.googleapis.com/books/v1/volumes/{bookId}");
        return response.getBody().asString();
    }
}
