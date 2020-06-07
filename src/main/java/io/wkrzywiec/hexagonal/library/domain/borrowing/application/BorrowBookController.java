package io.wkrzywiec.hexagonal.library.domain.borrowing.application;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowBookCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.BorrowBook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowBookController {

    @Qualifier("BorrowBook")
    private final BorrowBook borrowBook;

    @PostMapping("")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowBookCommand borrowBookCommand){
        borrowBook.handle(borrowBookCommand);
        return new ResponseEntity<>("Book with an id " + borrowBookCommand.getBookId() + " was borrowed", HttpStatus.OK);
    }
}
