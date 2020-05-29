package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.user.UserFacade;
import io.wkrzywiec.hexagonal.library.user.infrastructure.UserDatabaseAdapter;
import io.wkrzywiec.hexagonal.library.user.infrastructure.UserRepository;
import io.wkrzywiec.hexagonal.library.user.ports.incoming.AddNewUser;
import io.wkrzywiec.hexagonal.library.user.ports.outgoing.UserDatabase;
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
