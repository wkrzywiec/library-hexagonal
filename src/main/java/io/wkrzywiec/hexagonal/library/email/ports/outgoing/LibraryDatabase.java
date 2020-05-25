package io.wkrzywiec.hexagonal.library.email.ports.outgoing;

public interface LibraryDatabase {
    String getTitleByBookId(Long bookId);
    String getUserEmailAddress(Long userId);
}
