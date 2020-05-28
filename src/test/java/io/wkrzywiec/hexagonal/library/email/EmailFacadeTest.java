package io.wkrzywiec.hexagonal.library.email;

import io.wkrzywiec.hexagonal.library.TestData;
import io.wkrzywiec.hexagonal.library.email.model.SendReservationConfirmationCommand;
import io.wkrzywiec.hexagonal.library.email.ports.outgoing.EmailSender;
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

        database.bookTitles.put(1L, TestData.homoDeusBookTitle());
        database.emailAddresses.put(1L, "john.doe@test.com");
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
