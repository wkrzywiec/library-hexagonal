package io.wkrzywiec.hexagonal.library.user;

import io.wkrzywiec.hexagonal.library.user.model.NewUser;
import io.wkrzywiec.hexagonal.library.user.model.UserIdentifier;
import io.wkrzywiec.hexagonal.library.user.ports.outgoing.UserDatabase;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserDatabase implements UserDatabase {

    ConcurrentHashMap<Long, NewUser> users = new ConcurrentHashMap<>();

    @Override
    public UserIdentifier save(NewUser newUser) {
        Long id = users.size() + 1L;

        try {
            FieldUtils.writeField(newUser, "id", id, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        users.put(id, newUser);
        return new UserIdentifier(id);
    }
}
