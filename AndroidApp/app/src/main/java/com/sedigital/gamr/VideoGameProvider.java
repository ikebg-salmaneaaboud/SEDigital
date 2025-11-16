package com.sedigital.gamr;

import java.util.ArrayList;

public class VideoGameProvider {
    public ArrayList<VideoGame> getVideoGames() {
        ArrayList<VideoGame> videoGames = new ArrayList<>();
        videoGames.add(new VideoGame(
                "Red Dead Redemption II",
                "Acción",
                50.99,
                R.drawable.rdr2
        ));

        videoGames.add(new VideoGame(
                "Rainbow Six Extraction",
                "Acción / Shooter",
                63.99,
                R.drawable.rainbow
        ));

        videoGames.add(new VideoGame(
                "Achilles Legends Untold",
                "Acción / RPG",
                63.99,
                R.drawable.achilles
        ));

        videoGames.add(new VideoGame(
                "Cyberpunk 2077",
                "RPG",
                47.99,
                R.drawable.cyberpunk
        ));
        return videoGames;
    }
}
