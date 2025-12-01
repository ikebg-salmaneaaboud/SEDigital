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
import com.sedigital.gamr.ui.gamedetail.GameDetailActivity;

/**
 * Pantalla del catálogo de juegos.
 * Muestra los juegos en un RecyclerView con GridLayout de 2 columnas.
 * Incluye la barra de navegación inferior mediante BaseActivity.
 */
public class CatalogActivity extends BaseActivity {

    private VideoGameProvider videoGameProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        ImageView btnCart = findViewById(R.id.header_cart_icon);
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        });

        videoGameProvider = new VideoGameProvider();
        setupBottomNav(R.id.games);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerGames);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new CatalogAdapter(videoGameProvider.getVideoGames()));
    }
}
