package io.wkrzywiec.hexagonal.library.query;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/google/books")
@RequiredArgsConstructor
public class GoogleBooksSearchController {

    private final GoogleBookSearchClient client;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<String> searchForBooks(@RequestParam String query){
        return new ResponseEntity<>(client.searchForBooks(query), HttpStatus.OK);
    }
}
