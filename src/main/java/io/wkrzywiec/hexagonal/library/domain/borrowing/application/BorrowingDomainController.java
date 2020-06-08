package io.wkrzywiec.hexagonal.library.domain.borrowing.application;

import io.wkrzywiec.hexagonal.library.domain.borrowing.application.model.ChangeBookStatusRequest;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BorrowBookCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.GiveBackBookCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.BorrowBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.GiveBackBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.ReserveBook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BorrowingDomainController {

    @Qualifier("GiveBackBook")
    private final GiveBackBook giveBackBook;

    @Qualifier("ReserveBook")
    private final ReserveBook reserveBook;

    @Qualifier("BorrowBook")
    private final BorrowBook borrowBook;

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> borrowBook(@PathVariable("id") Long bookId, @RequestBody ChangeBookStatusRequest request){
        switch (request.getStatus()){
            case AVAILABLE:
                giveBackBook.handle(new GiveBackBookCommand(bookId, request.getUserId()));
                return new ResponseEntity<>("Book with an id " + bookId + " was returned", HttpStatus.OK);
            case RESERVED:
                Long reservationId = reserveBook.handle(new BookReservationCommand(bookId, request.getUserId()));
                return new ResponseEntity<>("Reservation has been made with an id " + reservationId, HttpStatus.OK);
            case BORROWED:
                borrowBook.handle(new BorrowBookCommand(bookId, request.getUserId()));
                return new ResponseEntity<>("Book with an id " + bookId + " was borrowed", HttpStatus.OK);
            default:
                return new ResponseEntity<>("Book can't have status: " + request.getStatus(), HttpStatus.BAD_REQUEST);
        }
    }
}
