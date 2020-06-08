package io.wkrzywiec.hexagonal.library.domain.user.infrastructure;

import io.wkrzywiec.hexagonal.library.DatabaseHelper;
import io.wkrzywiec.hexagonal.library.UserTestData;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.EmailAddress;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.User;
import io.wkrzywiec.hexagonal.library.domain.user.core.model.UserIdentifier;
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
    private DatabaseHelper databaseHelper;

    @Autowired
    private UserRepository userRepository;

    private UserDatabaseAdapter userDatabase;

    @BeforeEach
    public void init(){
        userDatabase = new UserDatabaseAdapter(userRepository);
        databaseHelper = new DatabaseHelper(jdbcTemplate);
    }

    @Test
    @DisplayName("Save new user in database")
    @Sql(scripts = "/clean-database.sql", executionPhase = AFTER_TEST_METHOD)
    public void shouldSaveDatabase(){
        //given
        User user = new User(
                new EmailAddress(UserTestData.johnDoeEmail()),
                "John",
                "Doe");

        //when
        UserIdentifier userIdentifier = userDatabase.save(user);

        //then
        Long savedUserId = databaseHelper.getJohnDoeUserId();

        assertEquals(userIdentifier.getAsLong(), savedUserId);
    }
}
