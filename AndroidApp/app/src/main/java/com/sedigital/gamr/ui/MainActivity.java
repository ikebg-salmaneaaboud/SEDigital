package com.sedigital.gamr.ui;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatActivity;
import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.auth.LoginActivity;
import com.sedigital.gamr.ui.auth.RegisterActivity;

/**
 * Pantalla de inicio (landing screen) de la app GAMR.
 * Muestra el logo, un subtítulo y dos botones de acción:
 *   - Registrarse: abre RegisterActivity
 *   - Iniciar sesión: abre LoginActivity
 *
 * Al hacer clic en cualquiera de los botones, la MainActivity se finaliza
 * para evitar volver a esta pantalla al pulsar "atrás".
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los botones de acción
        MaterialButton registerButton = findViewById(R.id.bRegister);
        MaterialButton loginButton = findViewById(R.id.bLogin);

        // Navegar a la pantalla de registro y cerrar MainActivity
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });

        // Navegar a la pantalla de login y cerrar MainActivity
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
