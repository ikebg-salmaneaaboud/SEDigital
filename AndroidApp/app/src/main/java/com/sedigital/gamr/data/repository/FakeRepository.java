package com.sedigital.gamr.data.repository;

import com.sedigital.gamr.data.mock.UserProvider;
import com.sedigital.gamr.data.mock.VideoGameProvider;
import com.sedigital.gamr.data.model.User;
import com.sedigital.gamr.data.model.VideoGame;

import java.util.ArrayList;
import java.util.List;

public class FakeRepository {

    private static FakeRepository instance;
    private UserProvider userProvider;
    private VideoGameProvider videoGameProvider;
    private List<User> users = new ArrayList<>();

    private FakeRepository() {
        userProvider = new UserProvider();
        videoGameProvider = new VideoGameProvider();

        users.addAll(userProvider.getUsers());
    }

    public static FakeRepository getInstance() {
        if (instance == null) {
            instance = new FakeRepository();
        }
        return instance;
    }

    // Users
    public List<User> getUsers() { return userProvider.getUsers(); }

    public void addUser(User user) {
        users.add(user);
    }

    // VideoGames
    public List<VideoGame> getVideoGames() { return videoGameProvider.getVideoGames(); }

}
