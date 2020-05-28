package io.wkrzywiec.hexagonal.library.email.infrastructure;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import io.wkrzywiec.hexagonal.library.email.model.ReservationConfirmEmail;
import io.wkrzywiec.hexagonal.library.email.ports.outgoing.EmailSender;

import java.io.IOException;

public class SendGridEmailSender implements EmailSender {

    @Override
    public void sendReservationConfirmationEmail(ReservationConfirmEmail reservationConfirmEmail) {
        Email from = new Email(reservationConfirmEmail.getFromEmailAddressAsString());
        Email to = new Email(reservationConfirmEmail.getToEmailAddressAsString());
        Content content = new Content("text/plain", reservationConfirmEmail.getContentAsString());
        Mail mail = new Mail(
                from,
                reservationConfirmEmail.getSubjectAsString(),
                to,
                content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        } catch (IOException ex) {
            System.out.print(ex);
        }
    }
}
