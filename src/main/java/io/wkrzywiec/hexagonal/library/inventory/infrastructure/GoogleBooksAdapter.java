package io.wkrzywiec.hexagonal.library.inventory.infrastructure;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.wkrzywiec.hexagonal.library.inventory.model.Author;
import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.model.BookIdentification;
import io.wkrzywiec.hexagonal.library.inventory.model.Isbn10;
import io.wkrzywiec.hexagonal.library.inventory.model.Isbn13;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.GetBookDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
public class GoogleBooksAdapter implements GetBookDetails {

    private final RestTemplate restTemplate;

    @Override
    public Book handle(String googleBookId) {

        HttpHeaders requestHeader = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeader);

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(
                        "https://www.googleapis.com/books/v1/volumes/" + googleBookId,
                        HttpMethod.GET,
                        requestEntity,
                        String.class);

        JsonObject response = ofNullable(responseEntity.getBody())
                .map(stringBody -> JsonParser.parseString(stringBody).getAsJsonObject())
                .orElseThrow(() -> new RuntimeException("There is no body inside the response from Google Books API"));

        JsonObject volumeInfo = response.getAsJsonObject("volumeInfo");

        Isbn10 isbn10 = new Isbn10(extractIsbn(volumeInfo, "ISBN_10"));
        Isbn13 isbn13 = new Isbn13(extractIsbn(volumeInfo, "ISBN_13"));

        return new Book(
                new BookIdentification(googleBookId, isbn10, isbn13),
                volumeInfo.get("title").getAsString(),
                extractAuthors(volumeInfo),
                volumeInfo.get("publisher").getAsString(),
                volumeInfo.get("publishedDate").getAsString(),
                volumeInfo.get("description").getAsString(),
                volumeInfo.get("pageCount").getAsInt(),
                extractImage(volumeInfo)
        );
    }

    private String extractIsbn(JsonObject volumeInfo, String isbnType) {
        return StreamSupport.stream(
                ofNullable(volumeInfo)
                        .map(volume -> volume.getAsJsonArray("industryIdentifiers"))
                        .orElseThrow(() -> new RuntimeException(""))
                        .spliterator(),
                false)
                .map(JsonElement::getAsJsonObject)
                .filter(isbnObject -> isbnObject.getAsJsonPrimitive("type").getAsString().equals(isbnType))
                .map(isbnObject -> isbnObject.getAsJsonPrimitive("identifier").getAsString())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Inside volumeInfo there is no " + isbnType));
    }

    private Set<Author> extractAuthors(JsonObject volumeInfo) {
        return StreamSupport.stream(
                ofNullable(volumeInfo)
                        .map(volume -> volume.getAsJsonArray("authors"))
                        .orElseThrow(() -> new RuntimeException(""))
                        .spliterator(),
                false)
                .map(JsonElement::getAsString)
                .map(Author::new)
                .collect(Collectors.toSet());
    }

    private String extractImage(JsonObject volumeInfo) {
        Set<Map.Entry<String, JsonElement>> imageLinksSet = volumeInfo.getAsJsonObject("imageLinks").entrySet();

        if (isImageThumbnailLinkInResponse(imageLinksSet)){
            return StreamSupport.stream(
                    imageLinksSet.spliterator(), false)
                    .filter(imageEntry -> imageEntry.getKey().equals("thumbnail"))
                    .findFirst()
                    .orElseThrow()
                    .getValue()
                    .getAsString();
        } else {
            return StreamSupport.stream(
                    imageLinksSet.spliterator(), false)
                    .map(entry -> entry.getValue().getAsString())
                    .findAny()
                    .orElse("");
        }
    }

    private boolean isImageThumbnailLinkInResponse(Set<Map.Entry<String, JsonElement>> imageLinksSet) {
        return StreamSupport.stream(
                        imageLinksSet.spliterator(), false)
                    .filter(entry -> entry.getKey().equals("thumbnail"))
                    .findFirst()
                    .isEmpty();
    }
}
