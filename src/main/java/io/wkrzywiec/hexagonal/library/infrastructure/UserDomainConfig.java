package io.wkrzywiec.hexagonal.library.infrastructure;

import io.wkrzywiec.hexagonal.library.domain.user.core.UserFacade;
import io.wkrzywiec.hexagonal.library.domain.user.infrastructure.UserDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.domain.user.infrastructure.UserRepository;
import io.wkrzywiec.hexagonal.library.domain.user.core.ports.incoming.AddNewUser;
import io.wkrzywiec.hexagonal.library.domain.user.core.ports.outgoing.UserDatabase;
import org.springframework.context.annotation.Bean;

public class UserDomainConfig {

    @Bean
    public UserDatabase userDatabase(UserRepository userRepository){
        return new UserDatabaseAdapter(userRepository);
    }

    @Bean
    public AddNewUser addNewUser(UserDatabase userDatabase){
        return new UserFacade(userDatabase);
    }
}
