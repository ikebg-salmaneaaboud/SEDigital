package com.sedigital.gamr.data.mock;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.CartItem;
import com.sedigital.gamr.data.model.VideoGame;

import java.util.ArrayList;

/**
 * Proveedor de datos simulados para el carrito de compras.
 * Devuelve una lista de CartItem con videojuegos predefinidos y su plataforma.
 */
public class CartProvider {
    /**
     * Retorna una lista simulada de items en el carrito.
     * Cada CartItem contiene un VideoGame y su plataforma correspondiente.
     * @return lista de CartItem
     */
    public ArrayList<CartItem> getCart() {
        ArrayList<CartItem> cart = new ArrayList<>();

        // ITEM 1
        ArrayList<Integer> rdr2Images = new ArrayList<>();
        rdr2Images.add(R.drawable.rdr_carousel_1);
        rdr2Images.add(R.drawable.rdr_carousel_2);
        rdr2Images.add(R.drawable.rdr_carousel_3);
        VideoGame v1 = new VideoGame(
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
        );
        cart.add(new CartItem(v1, R.drawable.ps5));

        // ITEM 2
        ArrayList<Integer> rainbowImages = new ArrayList<>();
        rainbowImages.add(R.drawable.rainbox_carousel_1);
        rainbowImages.add(R.drawable.rainbox_carousel_2);
        rainbowImages.add(R.drawable.rainbox_carousel_3);

        VideoGame v2 = new VideoGame(
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
        );
        cart.add(new CartItem(v2, R.drawable.windows));

        return cart;
    }
}
