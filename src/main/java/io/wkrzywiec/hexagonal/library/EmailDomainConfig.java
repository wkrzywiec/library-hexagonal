package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.email.EmailFacade;
import io.wkrzywiec.hexagonal.library.email.infrastructure.LibraryDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.email.infrastructure.SendGridEmailSender;
import io.wkrzywiec.hexagonal.library.email.ports.incoming.SendReservationConfirmation;
import io.wkrzywiec.hexagonal.library.email.ports.outgoing.EmailSender;
import io.wkrzywiec.hexagonal.library.email.ports.outgoing.LibraryDatabase;
import org.springframework.context.annotation.Bean;

public class EmailDomainConfig {

    @Bean
    public EmailSender emailSender() {
        return new SendGridEmailSender();
    }

    @Bean
    public LibraryDatabase libraryDatabase(){
        return new LibraryDatabaseAdapter();
    }

    @Bean
    public SendReservationConfirmation sendReservationConfirmation(EmailSender emailSender, LibraryDatabase database){
        return new EmailFacade(emailSender, database);
    }
}
