package com.sedigital.gamr;

import java.util.ArrayList;

public class VideoGameProvider {

    public ArrayList<VideoGame> getVideoGames() {
        ArrayList<VideoGame> videoGames = new ArrayList<>();

        ArrayList<Integer> rdr2Images = new ArrayList<>();
        rdr2Images.add(R.drawable.rdr_carousel_1);
        rdr2Images.add(R.drawable.rdr_carousel_2);
        rdr2Images.add(R.drawable.rdr_carousel_3);

        videoGames.add(new VideoGame(
                "Red Dead Redemption II",
                "Acción",
                50.99,
                "ROCKSTAR GAMES",
                4.8,
                "América, 1899. El ocaso del Salvaje Oeste ha comenzado...",
                R.drawable.rdr2,
                rdr2Images
        ));

        ArrayList<Integer> rainbowImages = new ArrayList<>();
        rainbowImages.add(R.drawable.rainbox_carousel_1);
        rainbowImages.add(R.drawable.rainbox_carousel_2);
        rainbowImages.add(R.drawable.rainbox_carousel_3);


        videoGames.add(new VideoGame(
                "Rainbow Six Extraction",
                "Acción / Shooter",
                63.99,
                "UBISOFT",
                4.2,
                "En Rainbow Six Extraction, los jugadores forman un equipo de operadores...",
                R.drawable.rainbow,
                rainbowImages
        ));

        ArrayList<Integer> achillesImages = new ArrayList<>();
        achillesImages.add(R.drawable.achilles_carousel_1);
        achillesImages.add(R.drawable.achilles_carousel_2);
        achillesImages.add(R.drawable.achilles_carousel_3);

        videoGames.add(new VideoGame(
                "Achilles Legends Untold",
                "Acción / RPG",
                63.99,
                "MYTHIC STUDIOS",
                4.5,
                "Embárcate en una aventura épica en el mundo de la antigua Grecia...",
                R.drawable.achilles,
                achillesImages
        ));

        ArrayList<Integer> cyberpunkImages = new ArrayList<>();
        cyberpunkImages.add(R.drawable.cyberpunk_carousel_1);
        cyberpunkImages.add(R.drawable.cyberpunk_carousel_2);
        cyberpunkImages.add(R.drawable.cyberpunk_carousel_3);

        videoGames.add(new VideoGame(
                "Cyberpunk 2077",
                "RPG",
                47.99,
                "CD PROJEKT RED",
                4.0,
                "Cyberpunk 2077 es un juego de rol ambientado en Night City...",
                R.drawable.cyberpunk,
                cyberpunkImages
        ));

        return videoGames;
    }
}
