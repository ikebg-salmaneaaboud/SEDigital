package com.sedigital.gamr.data.mock;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.VideoGame;

import java.util.ArrayList;

/**
 * Proveedor de datos simulados para videojuegos.
 * Devuelve una lista de VideoGame con información detallada para el catálogo.
 */
public class VideoGameProvider {

    /**
     * Retorna una lista de videojuegos simulados.
     * Cada VideoGame contiene título, categoría, precio, desarrollador,
     * rating, descripción, portada y lista de imágenes para el slider.
     * @return lista de VideoGame
     */
    public ArrayList<VideoGame> getVideoGames() {
        ArrayList<VideoGame> videoGames = new ArrayList<>();

        // Red Dead Redemption II
        ArrayList<Integer> rdr2Images = new ArrayList<>();
        rdr2Images.add(R.drawable.rdr_carousel_1);
        rdr2Images.add(R.drawable.rdr_carousel_2);
        rdr2Images.add(R.drawable.rdr_carousel_3);

        videoGames.add(new VideoGame(
                "Red Dead Redemption II",
                "Acción / Aventura",
                50.99,
                "ROCKSTAR GAMES",
                4.8,
                "América, 1899. El ocaso del Salvaje Oeste ha comenzado. " +
                        "Como Arthur Morgan, miembro de la banda Van der Linde, explorarás vastos paisajes, " +
                        "participarás en duelos, robos y decisiones que afectan tu honor y el destino de tu pandilla. " +
                        "Una historia épica de lealtad, traición y supervivencia en el último Oeste salvaje.",
                R.drawable.rdr2,
                rdr2Images
        ));

        // Rainbow Six Extraction
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
                "En Rainbow Six Extraction, los jugadores forman un equipo de operadores de élite para enfrentarse a " +
                        "una amenaza alienígena conocida como 'Archaeans'. Coordina estrategias, usa gadgets avanzados " +
                        "y trabaja en equipo para completar misiones peligrosas y sobrevivir a entornos hostiles llenos de tensión " +
                        "y acción intensa.",
                R.drawable.rainbow,
                rainbowImages
        ));

        // Achilles Legends Untold
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
                "Embárcate en una aventura épica en el mundo de la antigua Grecia. " +
                        "Controla a Aquiles y héroes legendarios mientras luchas contra criaturas mitológicas, " +
                        "exploras ciudades perdidas y tomas decisiones que cambian el curso de la historia. " +
                        "Una experiencia llena de combate estratégico, narrativa profunda y exploración sin límites.",
                R.drawable.achilles,
                achillesImages
        ));

        // Cyberpunk 2077
        ArrayList<Integer> cyberpunkImages = new ArrayList<>();
        cyberpunkImages.add(R.drawable.cyberpunk_carousel_1);
        cyberpunkImages.add(R.drawable.cyberpunk_carousel_2);
        cyberpunkImages.add(R.drawable.cyberpunk_carousel_3);

        videoGames.add(new VideoGame(
                "Cyberpunk 2077",
                "RPG / Futurista",
                47.99,
                "CD PROJEKT RED",
                4.0,
                "Cyberpunk 2077 te sumerge en Night City, una metrópolis futurista obsesionada con el poder, el glamour y la modificación corporal. " +
                        "Asume el papel de V, un mercenario en búsqueda de un implante único que otorga la inmortalidad. " +
                        "Toma decisiones que afectan tu historia, interactúa con personajes complejos y experimenta combates y misiones altamente personalizables.",
                R.drawable.cyberpunk,
                cyberpunkImages
        ));

        //FIFA 23
        ArrayList<Integer> fifa23Images = new ArrayList<>();
        fifa23Images.add(R.drawable.fifa23_carousel_3);
        fifa23Images.add(R.drawable.fifa23_carousel_2);
        fifa23Images.add(R.drawable.fifa23_carousel_1);

        videoGames.add(new VideoGame(
                "FIFA 23",
                "Deportes / Simulación",
                59.99,
                "EA SPORTS",
                4.3,
                "El Juego de todos al campo con los torneos de la Copa Mundial de la FIFA™ masculina y femenina, " +
                        "la inclusión de equipos de clubes femeninos por primera vez y funciones de juego cruzado." +
                        "Experimenta una autenticidad inigualable con más de 19,000 jugadores, 700 equipos y 30 ligas.",
                R.drawable.fifa23,
                fifa23Images
        ));

        //GTA 5
        ArrayList<Integer> gta5Images = new ArrayList<>();
        gta5Images.add(R.drawable.gta5_carousel_1);
        gta5Images.add(R.drawable.gta5_carousel_5);
        gta5Images.add(R.drawable.gta5_carousel_2);
        gta5Images.add(R.drawable.gta5_carousel_3);
        gta5Images.add(R.drawable.gta5_carousel_4);

        videoGames.add(new VideoGame(
                "GTA 5",
                "Acción / Aventura",
                29.99,
                "Rockstar Games",
                4.8,
                "Cuando un joven estafador callejero, un ladrón de bancos retirado y un psicópata aterrador se ven envueltos con lo peor y más desquiciado del mundo criminal, " +
                        "el gobierno de los EE. UU. y la industria del entretenimiento, deben llevar a cabo una serie de peligrosos atracos para sobrevivir " +
                        "en una ciudad implacable en la que no pueden confiar en nadie, y mucho menos los unos en los otros.",
                R.drawable.gta5,
                gta5Images
        ));

        return videoGames;
    }
}
