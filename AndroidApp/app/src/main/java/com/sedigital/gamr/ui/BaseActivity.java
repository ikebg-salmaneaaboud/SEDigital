package com.sedigital.gamr.ui;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.catalog.CatalogActivity;
import com.sedigital.gamr.ui.favorites.FavoritesActivity;
import com.sedigital.gamr.ui.home.HomeActivity;
import com.sedigital.gamr.ui.profile.ProfileActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected void setupBottomNav(int selectedItem) {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(selectedItem);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == selectedItem) return true;

            if (id == R.id.home) {
                startActivity(new Intent(this, HomeActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            if (id == R.id.games) {
                startActivity(new Intent(this, CatalogActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            if (id == R.id.favorites) {
                startActivity(new Intent(this, FavoritesActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            if (id == R.id.profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }

            return false;
        });
    }
}
