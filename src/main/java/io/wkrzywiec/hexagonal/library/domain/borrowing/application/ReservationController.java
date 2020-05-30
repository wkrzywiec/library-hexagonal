package io.wkrzywiec.hexagonal.library.domain.borrowing.application;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.ReserveBook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReserveBook reserveBook;

    @PostMapping("")
    public ResponseEntity<String> makeReservation(@RequestBody BookReservationCommand reservationCommand){
        Long reservationId = reserveBook.handle(reservationCommand);
        return new ResponseEntity<>("Reservation has been made with an id " + reservationId, HttpStatus.CREATED);
    }
}
