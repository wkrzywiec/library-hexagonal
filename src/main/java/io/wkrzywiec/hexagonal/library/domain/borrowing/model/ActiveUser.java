package io.wkrzywiec.hexagonal.library.domain.borrowing.model;

import io.wkrzywiec.hexagonal.library.domain.borrowing.model.exception.TooManyBooksAssignedToUserException;
import lombok.Getter;
import lombok.Value;

import java.util.List;

@Value
@Getter
public class ActiveUser {

    private Long id;
    List<Book> books;

    public ActiveUser(Long id, List<Book> books) {
        this.id = id;
        this.books = books;
    }

    public void assign(ReservedBook reservedBook) {
        if (books.size() < 3){
            books.add(reservedBook);
        } else {
            throw new TooManyBooksAssignedToUserException(id);
        }
    }
}
