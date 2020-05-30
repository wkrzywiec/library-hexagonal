package io.wkrzywiec.hexagonal.library.domain.email;

import io.wkrzywiec.hexagonal.library.BookTestData;
import io.wkrzywiec.hexagonal.library.UserTestData;
import io.wkrzywiec.hexagonal.library.domain.email.core.EmailFacade;
import io.wkrzywiec.hexagonal.library.domain.email.core.model.SendReservationConfirmationCommand;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing.EmailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmailFacadeTest {

    private EmailFacade facade;
    private EmailSender emailSender;
    private InMemoryEmailDatabase database;


    @BeforeEach
    public void init() {
        database = new InMemoryEmailDatabase();
        emailSender = new EmailSenderFake();
        facade = new EmailFacade(emailSender, database);

        database.bookTitles.put(1L, BookTestData.homoDeusBookTitle());
        database.emailAddresses.put(1L, UserTestData.johnDoeEmail());
    }

    @Test
    @DisplayName("Prepare & send reservation confirmation email")
    public void shouldPrepareAndSendReservationConfirmation(){
        //given
        SendReservationConfirmationCommand sendReservationConfirmationCommand
                = new SendReservationConfirmationCommand(1L, 1L, 1L);

        //when & then
        assertDoesNotThrow(() -> facade.handle(sendReservationConfirmationCommand));
    }
}
