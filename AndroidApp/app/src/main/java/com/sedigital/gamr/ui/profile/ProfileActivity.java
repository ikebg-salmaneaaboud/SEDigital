package com.sedigital.gamr.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.BaseActivity;
import com.sedigital.gamr.ui.MainActivity;
import com.sedigital.gamr.ui.auth.RegisterActivity;

/**
 * Actividad que muestra el perfil del usuario.
 * Hereda de BaseActivity para disponer de la BottomNavigationView.
 */
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupBottomNav(R.id.profile);

        MaterialButton logoutButton = findViewById(R.id.btnLogOut);

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
