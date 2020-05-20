package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.inventory.model.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.inventory.model.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.inventory.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.GetBookDetails;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryDatabase;

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
