package io.wkrzywiec.hexagonal.library.email;

import io.wkrzywiec.hexagonal.library.email.ports.outgoing.LibraryDatabase;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLibraryDatabase implements LibraryDatabase {

    ConcurrentHashMap<Long, String> bookTitles = new ConcurrentHashMap<>();
    ConcurrentHashMap<Long, String> emailAddresses = new ConcurrentHashMap<>();

    @Override
    public String getTitleByBookId(Long bookId) {
        return bookTitles.get(bookId);
    }

    @Override
    public String getUserEmailAddress(Long userId) {
        return emailAddresses.get(userId);
    }
}
