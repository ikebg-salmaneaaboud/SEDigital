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

/**
 * Pantalla de registro de usuario.
 * Valida datos introducidos, evita duplicados y guarda
 * nuevos usuarios en el repositorio simulado.
 */
public class RegisterActivity extends AppCompatActivity {

    // Campos de entrada para email y contraseña con sus confirmaciones
    private EditText etEmail, etEmailConfirm, etPassword, etPasswordConfirm;

    // Botón que procesa el registro
    private MaterialButton btnRegister;

    // Enlace para volver al login
    private TextView loginLink;

    // Repositorio simulado donde se almacenan los usuarios
    private FakeRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Referencias a los elementos visuales
        etEmail = findViewById(R.id.etRegisterEmail);
        etEmailConfirm = findViewById(R.id.etRegisterEmailConfirm);
        etPassword = findViewById(R.id.etRegisterPassword);
        etPasswordConfirm = findViewById(R.id.etRegisterPasswordConfirm);
        btnRegister = findViewById(R.id.btnRegister);
        loginLink = findViewById(R.id.loginLink);

        // Inicialización del repositorio falso
        repo = FakeRepository.getInstance();

        // Acción del botón de registro
        btnRegister.setOnClickListener(v -> registerUser());

        // Enlace para volver al login
        loginLink.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });
    }

    /**
     * Valida los datos introducidos, comprueba duplicados
     * y registra un nuevo usuario si todo es correcto.
     */
    private void registerUser() {

        // Lectura de valores y eliminación de espacios innecesarios
        String email = etEmail.getText().toString().trim();
        String emailConfirm = etEmailConfirm.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String passwordConfirm = etPasswordConfirm.getText().toString().trim();

        // Validación de campos vacíos
        if (email.isEmpty() || emailConfirm.isEmpty()
                || password.isEmpty() || passwordConfirm.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Confirmación de email
        if (!email.equals(emailConfirm)) {
            Toast.makeText(this, "Los correos no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Confirmación de contraseña
        if (!password.equals(passwordConfirm)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validación de email único
        for (User u : repo.getUsers()) {
            if (u.getEmail().equals(email)) {
                Toast.makeText(this, "Este correo ya está registrado", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Creación y almacenamiento del nuevo usuario
        User newUser = new User(email, password, "");
        repo.addUser(newUser);

        Toast.makeText(this, "Cuenta creada. Inicia sesión", Toast.LENGTH_SHORT).show();

        // Redirección al login
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
}
