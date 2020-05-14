package io.wkrzywiec.hexagonal.library.application;

import io.wkrzywiec.hexagonal.library.domain.book.model.ExternalBookIdDTO;
import io.wkrzywiec.hexagonal.library.domain.book.ports.incoming.AddNewBook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookCommandController {

    private final AddNewBook addNewBook;

    @PostMapping("")
    ResponseEntity<String> addNewBook(@RequestBody ExternalBookIdDTO externalBookIdDTO){
        addNewBook.handle(externalBookIdDTO);
        return new ResponseEntity<>("New book was added to library", HttpStatus.CREATED);
    }
}
