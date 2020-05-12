package io.wkrzywiec.hexagonal.library.infrastructure;

import io.restassured.path.json.JsonPath;
import io.wkrzywiec.hexagonal.library.domain.book.model.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.GetBookDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class GoogleBooksAdapter implements GetBookDetails {

    @Override
    public BookDetailsDTO handle(String googleBookId) {

        JsonPath response =
                given()
                        .pathParam("bookId", googleBookId)
                .when()
                        .get("https://www.googleapis.com/books/v1/volumes/{bookId}")
                        .jsonPath();

        return BookDetailsDTO.builder()
                .bookExternalId(googleBookId)
                .isbn10(extractIsbn(response, "ISBN_10"))
                .isbn13(extractIsbn(response, "ISBN_13"))
                .title(response.getString("volumeInfo.title"))
                .authors(extractAuthors(response))
                .publisher(response.getString("volumeInfo.publisher"))
                .publishedDate(response.getString("volumeInfo.publishedDate"))
                .description(response.getString("volumeInfo.description"))
                .pages(response.getInt("volumeInfo.pageCount"))
                .imageLink(extractImage(response))
                .build();
    }

    private String extractIsbn(JsonPath response, String isbnType){
        return response.getList("volumeInfo.industryIdentifiers")
                .stream()
                .map(isbnObj -> (Map<String, String>) isbnObj)
                .filter(isbnMap -> isbnMap.containsValue(isbnType))
                .map(isbnMap -> isbnMap.get("identifier"))
                .findFirst()
                .orElse("");
    }

    private List<String> extractAuthors(JsonPath response) {
        return response.getList("volumeInfo.authors")
                .stream()
                .map(authorObj -> (String) authorObj)
                .collect(Collectors.toList());
    }

    private String extractImage(JsonPath response){
        Map<String, String> imagesMap = response.getMap("volumeInfo.imageLinks");
        if (imagesMap.containsKey("thumbnail")){
            return imagesMap.get("thumbnail");
        } else {
            return (String) new ArrayList<Object>(imagesMap.values()).get(0);
        }
    }
}
