package io.wkrzywiec.hexagonal.library.domain.borrowing.application;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.GiveBackBookCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.GiveBackBook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/giveBack")
@RequiredArgsConstructor
public class GiveBackController {

    @Qualifier("GiveBackBook")
    private final GiveBackBook giveBackBook;

    @PostMapping("")
    public ResponseEntity<String> giveBack(@RequestBody GiveBackBookCommand giveBackBookCommand){
        giveBackBook.handle(giveBackBookCommand);
        return new ResponseEntity<>("Book with an id " + giveBackBookCommand.getBookId() + " was returned", HttpStatus.OK);
    }
}
