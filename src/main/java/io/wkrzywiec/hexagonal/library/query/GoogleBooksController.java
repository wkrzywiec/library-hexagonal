package io.wkrzywiec.hexagonal.library.query;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/google/books")
@RequiredArgsConstructor
public class GoogleBooksController {

    private final GoogleBooksClient client;

    @GetMapping("")
    public ResponseEntity<String> searchForBooks(@RequestParam String query){
        return new ResponseEntity<>(client.searchForBooks(query), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<String> getBookBId(@PathVariable String bookId){
        return new ResponseEntity<>(client.getBookById(bookId), HttpStatus.OK);
    }
}
