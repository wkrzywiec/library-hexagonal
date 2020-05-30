package io.wkrzywiec.hexagonal.library.domain.inventory.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddNewBookCommand {
    private String googleBookId;
}
