package io.wkrzywiec.hexagonal.library.domain.borrowing.core.model;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.exception.TooManyBooksAssignedToUserException;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class ActiveUser {

    private final Long id;
    private final List<ReservedBook> reservedBooks;
    private final List<BorrowedBook> borrowedBooks;

    public ActiveUser(Long id, List<ReservedBook> reservedBooks, List<BorrowedBook> borrowedBooks) {
        this.id = id;
        this.reservedBooks = reservedBooks;
        this.borrowedBooks = borrowedBooks;
    }

    public ReservedBook reserve(AvailableBook availableBook){
        if (hasUserNotReachedLimitOfBooks()){
            ReservedBook reservedBook = new ReservedBook(availableBook.getIdAsLong(), id);
            reservedBooks.add(reservedBook);
            return reservedBook;
        } else {
            throw new TooManyBooksAssignedToUserException(id);
        }
    }

    public BorrowedBook borrow(ReservedBook reservedBook) {
        if (hasUserNotReachedLimitOfBooks()){
            BorrowedBook borrowedBook = new BorrowedBook(reservedBook.getIdAsLong(), id);
            borrowedBooks.add(borrowedBook);
            return borrowedBook;
        } else {
            throw new TooManyBooksAssignedToUserException(id);
        }
    }

    public Long getIdAsLong(){
        return id;
    }

    public List<ReservedBook> getReservedBookList(){
        return reservedBooks;
    }

    public List<BorrowedBook> getBorrowedBookList() {
        return borrowedBooks;
    }

    private boolean hasUserNotReachedLimitOfBooks(){
        return reservedBooks.size() + borrowedBooks.size() < 3;
    }
}
