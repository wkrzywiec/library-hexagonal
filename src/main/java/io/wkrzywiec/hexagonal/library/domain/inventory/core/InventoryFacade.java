package io.wkrzywiec.hexagonal.library.domain.inventory.core;

import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.AddNewBookCommand;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.Book;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.model.NewBookWasAddedEvent;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.incoming.AddNewBook;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing.InventoryEventPublisher;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing.GetBookDetails;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.ports.outgoing.InventoryDatabase;


public class InventoryFacade implements AddNewBook{

    private InventoryDatabase database;
    private GetBookDetails getBookDetails;
    private InventoryEventPublisher eventPublisher;

    public InventoryFacade(InventoryDatabase database, GetBookDetails getBookDetails, InventoryEventPublisher eventPublisher) {
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
