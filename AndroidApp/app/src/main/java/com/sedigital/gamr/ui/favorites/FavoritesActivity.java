package com.sedigital.gamr.ui.favorites;

import android.os.Bundle;

import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.BaseActivity;

/**
 * Pantalla que muestra los juegos marcados como favoritos.
 * Hereda de BaseActivity para incluir la barra de navegación inferior.
 */
public class FavoritesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        // Configura la navegación inferior resaltando la sección de favoritos
        setupBottomNav(R.id.favorites);
    }
}
