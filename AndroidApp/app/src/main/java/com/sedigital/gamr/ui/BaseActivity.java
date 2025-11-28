package com.sedigital.gamr.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.catalog.CatalogActivity;
import com.sedigital.gamr.ui.favorites.FavoritesActivity;
import com.sedigital.gamr.ui.home.HomeActivity;
import com.sedigital.gamr.ui.profile.ProfileActivity;

/**
 * Clase base para actividades que comparten la barra de navegación inferior.
 * Proporciona funcionalidad común de selección y navegación entre pantallas.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Configura la BottomNavigationView y gestiona la navegación entre actividades.
     *
     * @param selectedItem Id del item que debe aparecer seleccionado en la barra.
     */
    protected void setupBottomNav(int selectedItem) {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(selectedItem);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == selectedItem) return true;

            Intent intent = null;
            if (id == R.id.home) intent = new Intent(this, HomeActivity.class);
            if (id == R.id.games) intent = new Intent(this, CatalogActivity.class);
            if (id == R.id.favorites) intent = new Intent(this, FavoritesActivity.class);
            if (id == R.id.profile) intent = new Intent(this, ProfileActivity.class);

            if (intent != null) {
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            }

            return false;
        });
    }
}
