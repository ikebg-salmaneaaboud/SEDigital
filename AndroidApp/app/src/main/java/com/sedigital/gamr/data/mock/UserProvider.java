package com.sedigital.gamr.data.mock;

import com.sedigital.gamr.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserProvider {

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("test", "123", "Test User"));
        users.add(new User("admin@example.com", "admin123", "Admin"));
        users.add(new User("player@example.com", "playerpass", "Player One"));

        return users;
    }
}
