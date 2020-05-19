package io.wkrzywiec.hexagonal.library.domain.borrowing;

import io.wkrzywiec.hexagonal.library.ReservationTestData;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.ActiveUser;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.AvailableBook;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.BookReservationCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.MakeBookAvailableCommand;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.exception.ActiveUserNotFoundException;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.exception.AvailableBookNotFoundExeption;
import io.wkrzywiec.hexagonal.library.domain.borrowing.model.exception.TooManyBooksAssignedToUserException;
import io.wkrzywiec.hexagonal.library.domain.borrowing.ports.outgoing.EmailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BorrowingFacadeTest {

    private BorrowingFacade facade;
    private InMemoryBorrowingDatabase database;
    @Mock
    private EmailSender emailSender;

    @BeforeEach
    public void init(){
        database = new InMemoryBorrowingDatabase();
        facade = new BorrowingFacade(database, emailSender);
    }

    @Test
    @DisplayName("Make book available")
    public void whenMakeBookAvailableCommandReceived_thenBookIsOnAvailableStatus() {
        //given
        MakeBookAvailableCommand makeBookAvailableCommand =
                MakeBookAvailableCommand.builder()
                        .bookId(100L)
                        .build();

        //when
        facade.handle(makeBookAvailableCommand);

        //then
        assertTrue(database.availableBooks.containsKey(100L));
        assertTrue(database.availableBooks.containsValue(new AvailableBook(100L)));
    }

    @Test
    @DisplayName("Make successful book reservation")
    public void givenAvailableBooksAndActiveUser_whenMakingReservation_thenBookIsReserved(){
        //given
        BookReservationCommand reservationCommand = ReservationTestData.anyBookReservation(100L, 100L);
        AvailableBook availableBook = ReservationTestData.anyAvailableBook(reservationCommand.getBookId());
        ActiveUser activeUser = ReservationTestData.anyActiveUser(reservationCommand.getUserId());

        database.activeUsers.put(activeUser.getId(), activeUser);
        database.availableBooks.put(availableBook.getId(), availableBook);

        //when
        facade.handle(reservationCommand);

        //then
        assertEquals(1, activeUser.getBooks().size());
        assertEquals(availableBook.getId(), activeUser.getBooks().get(0).getId());
    }

    @Test
    @DisplayName("User can't have more than 3 reservations")
    public void givenActiveUserAlreadyHas3Books_whenMakingReservation_thenBookIsNotReserved(){
        //given
        BookReservationCommand firstReservationCommand = ReservationTestData.anyBookReservation(100L, 100L);
        BookReservationCommand secondReservationCommand = ReservationTestData.anyBookReservation(101L, 100L);
        BookReservationCommand thirdReservationCommand = ReservationTestData.anyBookReservation(102L, 100L);
        BookReservationCommand fourthReservationCommand = ReservationTestData.anyBookReservation(103L, 100L);

        AvailableBook availableBookNo1 = ReservationTestData.anyAvailableBook(firstReservationCommand.getBookId());
        AvailableBook availableBookNo2 = ReservationTestData.anyAvailableBook(secondReservationCommand.getBookId());
        AvailableBook availableBookNo3 = ReservationTestData.anyAvailableBook(thirdReservationCommand.getBookId());
        AvailableBook availableBookNo4 = ReservationTestData.anyAvailableBook(fourthReservationCommand.getBookId());

        ActiveUser activeUser = ReservationTestData.anyActiveUser(firstReservationCommand.getUserId());

        database.availableBooks.put(availableBookNo1.getId(), availableBookNo1);
        database.availableBooks.put(availableBookNo2.getId(), availableBookNo2);
        database.availableBooks.put(availableBookNo3.getId(), availableBookNo3);
        database.availableBooks.put(availableBookNo4.getId(), availableBookNo4);
        database.activeUsers.put(activeUser.getId(), activeUser);

        facade.handle(firstReservationCommand);
        facade.handle(secondReservationCommand);
        facade.handle(thirdReservationCommand);

        //when & then
        assertThrows(
                TooManyBooksAssignedToUserException.class,
                () -> facade.handle(fourthReservationCommand));
    }

    @Test
    @DisplayName("Try to reserve book,but it's not available")
    public void givenNotAvailableBook_whenMakingReservation_thenThrowException(){
        //given
        BookReservationCommand reservationCommand = ReservationTestData.anyBookReservation(100L, 100L);
        ActiveUser activeUser = ReservationTestData.anyActiveUser(reservationCommand.getUserId());

        database.activeUsers.put(activeUser.getId(), activeUser);

        assertThrows(
                AvailableBookNotFoundExeption.class,
                () -> facade.handle(reservationCommand));
    }

    @Test
    @DisplayName("Try to reserve book, but active user is not found")
    public void givenNotActiveUser_whenMakingReservation_thenThrowException(){
        //given
        BookReservationCommand reservationCommand = ReservationTestData.anyBookReservation(100L, 100L);
        AvailableBook availableBook = ReservationTestData.anyAvailableBook(reservationCommand.getBookId());

        database.availableBooks.put(availableBook.getId(), availableBook);

        //when & then
        assertThrows(
                ActiveUserNotFoundException.class,
                () -> facade.handle(reservationCommand));
    }
}
