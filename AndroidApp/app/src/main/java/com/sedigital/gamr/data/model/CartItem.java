package com.sedigital.gamr.data.model;

public class CartItem {
    private VideoGame videoGame;
    private int platform;

    public CartItem(VideoGame videoGame, int platform) {
        this.videoGame = videoGame;
        this.platform = platform;
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public void setVideoGame(VideoGame videoGame) {
        this.videoGame = videoGame;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }
}
