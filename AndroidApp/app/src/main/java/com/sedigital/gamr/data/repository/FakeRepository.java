package com.sedigital.gamr.data.repository;

import com.sedigital.gamr.data.mock.UserProvider;
import com.sedigital.gamr.data.mock.VideoGameProvider;
import com.sedigital.gamr.data.model.User;
import com.sedigital.gamr.data.model.VideoGame;

import java.util.List;

public class FakeRepository {

    private static FakeRepository instance;
    private UserProvider userProvider;
    private VideoGameProvider videoGameProvider;

    private FakeRepository() {
        userProvider = new UserProvider();
        videoGameProvider = new VideoGameProvider();
    }

    public static FakeRepository getInstance() {
        if (instance == null) {
            instance = new FakeRepository();
        }
        return instance;
    }

    // Users
    public List<User> getUsers() { return userProvider.getUsers(); }

    // VideoGames
    public List<VideoGame> getVideoGames() { return videoGameProvider.getVideoGames(); }

}
