package io.wkrzywiec.hexagonal.library.email.infrastructure;

import io.wkrzywiec.hexagonal.library.email.ports.outgoing.LibraryDatabase;

public class LibraryDatabaseAdapter implements LibraryDatabase {

    @Override
    public String getTitleByBookId(Long bookId) {
        return null;
    }

    @Override
    public String getUserEmailAddress(Long userId) {
        return null;
    }
}
