package io.wkrzywiec.hexagonal.library.inventory;

import io.wkrzywiec.hexagonal.library.inventory.model.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.inventory.model.Book;
import io.wkrzywiec.hexagonal.library.inventory.model.NewBookWasAddedEvent;
import io.wkrzywiec.hexagonal.library.inventory.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.EventPublisher;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.GetBookDetails;
import io.wkrzywiec.hexagonal.library.inventory.ports.outgoing.InventoryDatabase;


public class InventoryFacade implements AddNewBook{

    private InventoryDatabase database;
    private GetBookDetails getBookDetails;
    private EventPublisher eventPublisher;

    public InventoryFacade(InventoryDatabase database, GetBookDetails getBookDetails, EventPublisher eventPublisher) {
        this.database = database;
        this.getBookDetails = getBookDetails;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void handle(AddNewBookCommand addNewBookCommand){
        Book book = getBookDetails.handle(addNewBookCommand.getGoogleBookId());
        Book savedBook = database.save(book);
        eventPublisher.publishNewBookWasAddedEvent(new NewBookWasAddedEvent(savedBook.getIdAsLong()));
    }
}
