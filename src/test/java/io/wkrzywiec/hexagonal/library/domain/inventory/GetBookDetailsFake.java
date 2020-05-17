package io.wkrzywiec.hexagonal.library.domain.inventory;

import io.wkrzywiec.hexagonal.library.InventoryTestData;
import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.GetBookDetails;

import java.util.HashMap;
import java.util.Map;

public class GetBookDetailsFake implements GetBookDetails {

    private Map<String, BookDetailsDTO> bookDetails;

    public GetBookDetailsFake() {
        bookDetails = new HashMap<String, BookDetailsDTO>();
        bookDetails.put(
                InventoryTestData.homoDeusBookDetailsDTO().getBookExternalId(),
                InventoryTestData.homoDeusBookDetailsDTO());
    }

    @Override
    public BookDetailsDTO handle(String bookId) {
        return bookDetails.get(bookId);
    }
}
