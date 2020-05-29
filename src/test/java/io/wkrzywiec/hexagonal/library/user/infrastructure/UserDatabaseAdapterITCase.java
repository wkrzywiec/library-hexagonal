package io.wkrzywiec.hexagonal.library.user.infrastructure;

import io.wkrzywiec.hexagonal.library.UserTestData;
import io.wkrzywiec.hexagonal.library.user.model.EmailAddress;
import io.wkrzywiec.hexagonal.library.user.model.User;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
public class UserDatabaseAdapterITCase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    private UserDatabaseAdapter userDatabase;

    @BeforeEach
    public void init(){
        userDatabase = new UserDatabaseAdapter(userRepository);
    }

    @Test
    @DisplayName("Save new user in database")
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void shouldSaveDatabase(){
        //given
        User user = new User(
                new EmailAddress(UserTestData.johnDoeEmail()),
                "John",
                "Doe"
        );

        //when
        UserIdentifier userIdentifier = userDatabase.save(user);

        //then
        Long savedUserId = jdbcTemplate.queryForObject(
                "SELECT id FROM user WHERE email = ?",
                Long.class,
                UserTestData.johnDoeEmail());

        assertEquals(userIdentifier.getAsLong(), savedUserId);
    }
}
