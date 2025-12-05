package com.sedigital.gamr.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.User;
import com.sedigital.gamr.data.repository.FakeRepository;
import com.sedigital.gamr.ui.catalog.CatalogActivity;

import java.util.List;

/**
 * Pantalla de inicio de sesión.
 * Valida credenciales contra un repositorio simulado
 * y redirige al catálogo si el acceso es correcto.
 */
public class LoginActivity extends AppCompatActivity {

    // Campos de entrada para email y contraseña
    private EditText etEmail, etPassword;

    // Botón para enviar credenciales
    private MaterialButton btnConfirmLogin;

    // Enlace hacia la pantalla de registro
    private TextView registerLink;

    // Lista de usuarios simulados obtenidos del repositorio
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referencias a las vistas del layout
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnConfirmLogin = findViewById(R.id.btnConfirmLogin);
        registerLink = findViewById(R.id.tvRegister);

        // Se obtienen los usuarios desde el repositorio falso
        users = FakeRepository.getInstance().getUsers();

        // Acción del botón de login
        btnConfirmLogin.setOnClickListener(v -> {
            // Se obtienen los valores introducidos
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Validación de campos vacíos
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingresa email y contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            // Búsqueda del usuario que coincida con email y contraseña
            User matchedUser = null;
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    matchedUser = user;
                    break;
                }
            }

            // Si el usuario existe, se inicia la siguiente actividad
            if (matchedUser != null) {
                Toast.makeText(this, "Bienvenido " + matchedUser.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, CatalogActivity.class);
                startActivity(intent);
                finish(); // cierra la pantalla de login
            } else {
                // Credenciales incorrectas
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        // Acción del enlace para ir al registro
        registerLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}
