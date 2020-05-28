package io.wkrzywiec.hexagonal.library.email.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReservationConfirmEmail {

    private final EmailAddress from;
    private final EmailAddress to;
    private final String subject;
    private final String content;

    public String getFromEmailAddressAsString(){
        return this.from.getAsString();
    }

    public String getToEmailAddressAsString(){
        return this.to.getAsString();
    }

    public String getSubjectAsString(){
        return this.subject;
    }

    public String getContentAsString(){
        return this.content;
    }
}
