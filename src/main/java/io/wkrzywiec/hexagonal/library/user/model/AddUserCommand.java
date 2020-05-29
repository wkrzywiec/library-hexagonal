package io.wkrzywiec.hexagonal.library.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserCommand {

    private String email;
    private String firstName;
    private String lastName;
}
