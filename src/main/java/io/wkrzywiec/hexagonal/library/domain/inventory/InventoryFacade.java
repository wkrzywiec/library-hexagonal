package io.wkrzywiec.hexagonal.library.domain.inventory;

import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.inventory.dto.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.GetBookDetails;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.InventoryDatabase;

public class InventoryFacade implements AddNewBook{

    private InventoryDatabase database;
    private GetBookDetails getBookDetails;

    public InventoryFacade(InventoryDatabase database, GetBookDetails getBookDetails) {
        this.database = database;
        this.getBookDetails = getBookDetails;
    }

    @Override
    public void handle(AddNewBookCommand addNewBookCommand){
        BookDetailsDTO bookDetails = getBookDetails.handle(addNewBookCommand.getGoogleBookId());
        database.save(bookDetails);
    }
}
