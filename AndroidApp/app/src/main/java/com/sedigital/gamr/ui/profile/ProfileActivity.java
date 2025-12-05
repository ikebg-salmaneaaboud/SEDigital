package com.sedigital.gamr.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.BaseActivity;
import com.sedigital.gamr.ui.MainActivity;

/**
 * Actividad que muestra el perfil del usuario.
 * Hereda de BaseActivity para disponer de la barra de navegación inferior.
 * Permite al usuario cerrar sesión y regresar a la pantalla principal.
 */
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Configura la navegación inferior resaltando la sección de perfil
        setupBottomNav(R.id.profile);

        // Botón para cerrar sesión
        MaterialButton logoutButton = findViewById(R.id.btnLogOut);
        logoutButton.setOnClickListener(v -> {
            // Redirige a MainActivity y cierra ProfileActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
