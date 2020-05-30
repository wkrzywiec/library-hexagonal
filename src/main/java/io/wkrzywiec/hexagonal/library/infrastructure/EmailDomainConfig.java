package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.email.core.EmailFacade;
import io.wkrzywiec.hexagonal.library.domain.email.infrastructure.EmailDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.domain.email.infrastructure.SendGridEmailSender;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.incoming.SendReservationConfirmation;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing.EmailSender;
import io.wkrzywiec.hexagonal.library.domain.email.core.ports.outgoing.EmailDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmailDomainConfig {

    @Bean
    public EmailSender emailSender() {
        return new SendGridEmailSender();
    }

    @Bean
    public EmailDatabase libraryDatabase(JdbcTemplate jdbcTemplate){
        return new EmailDatabaseAdapter(jdbcTemplate);
    }

    @Bean
    public SendReservationConfirmation sendReservationConfirmation(EmailSender emailSender, EmailDatabase database){
        return new EmailFacade(emailSender, database);
    }
}
