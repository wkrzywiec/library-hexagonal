package io.wkrzywiec.hexagonal.library.infrastructure.adapter;

import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;
import io.wkrzywiec.hexagonal.library.domain.inventory.ports.outgoing.InventoryDatabase;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.AuthorEntiy;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.BookEntity;
import io.wkrzywiec.hexagonal.library.infrastructure.repository.PostgresBookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class InventoryDatabaseAdapter implements InventoryDatabase {

    private final PostgresBookRepository repository;

    @Override
    public void save(BookDetailsDTO bookDetailsDTO) {
        BookEntity bookEntity = BookEntity.builder()
                .bookExternalId(bookDetailsDTO.getBookExternalId())
                .isbn10(bookDetailsDTO.getIsbn10())
                .isbn13(bookDetailsDTO.getIsbn13())
                .title(bookDetailsDTO.getTitle())
                .authors(mapToAuthorList(bookDetailsDTO.getAuthors()))
                .publisher(bookDetailsDTO.getPublisher())
                .publishedDate(bookDetailsDTO.getPublishedDate())
                .description(bookDetailsDTO.getDescription())
                .pages(bookDetailsDTO.getPages())
                .imageLink(bookDetailsDTO.getImageLink())
                .build();
        repository.save(bookEntity);
    }

    private Set<AuthorEntiy> mapToAuthorList(List<String> authorNameList){
        return authorNameList.stream()
                .map(authorName -> AuthorEntiy.builder().name(authorName).build())
                .collect(Collectors.toUnmodifiableSet());
    }
}
