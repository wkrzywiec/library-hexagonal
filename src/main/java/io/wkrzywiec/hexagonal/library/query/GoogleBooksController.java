package io.wkrzywiec.hexagonal.library.query;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/google/books")
@RequiredArgsConstructor
public class GoogleBooksController {

    private final GoogleBooksClient client;

    @GetMapping("")
    public ResponseEntity<Object> searchForBooks(@RequestParam String query){
        return new ResponseEntity<>(client.searchForBooks(query), HttpStatus.OK);
    }
}
