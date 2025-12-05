package com.sedigital.gamr.ui.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.mock.VideoGameProvider;
import com.sedigital.gamr.ui.BaseActivity;
import com.sedigital.gamr.ui.cart.CartActivity;

/**
 * Pantalla que muestra el catálogo de videojuegos.
 * Los juegos se presentan en un RecyclerView con un grid de 2 columnas.
 * Extiende BaseActivity para incluir la barra de navegación inferior.
 */
public class CatalogActivity extends BaseActivity {

    // Proveedor de datos de videojuegos simulados
    private VideoGameProvider videoGameProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Botón para abrir la pantalla del carrito
        ImageView btnCart = findViewById(R.id.header_cart_icon);
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        });

        // Inicializa la fuente de datos de videojuegos
        videoGameProvider = new VideoGameProvider();

        // Configura la navegación inferior resaltando la sección actual
        setupBottomNav(R.id.games);

        // Inicializa el RecyclerView que mostrará los juegos
        initRecyclerView();
    }

    /**
     * Configura el RecyclerView con un GridLayout de 2 columnas
     * y le asigna un adaptador que muestra los videojuegos.
     */
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerGames);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new CatalogAdapter(videoGameProvider.getVideoGames()));
    }
}
