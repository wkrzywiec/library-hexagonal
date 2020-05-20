package io.wkrzywiec.hexagonal.library.inventory.application;

import io.wkrzywiec.hexagonal.library.inventory.model.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.inventory.ports.incoming.AddNewBook;
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
    public ResponseEntity<String> addNewBook(@RequestBody AddNewBookCommand addNewBookCommand){
        addNewBook.handle(addNewBookCommand);
        return new ResponseEntity<>("New book was added to library", HttpStatus.CREATED);
    }
}
