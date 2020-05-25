package io.wkrzywiec.hexagonal.library.email.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Email {

    private final EmailAddress from;
    private final EmailAddress to;
    private final String subject;
    private final String content;
}
