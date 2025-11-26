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

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etEmailConfirm, etPassword, etPasswordConfirm;
    private MaterialButton btnRegister;
    private TextView loginLink;
    private FakeRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etRegisterEmail);
        etEmailConfirm = findViewById(R.id.etRegisterEmailConfirm);
        etPassword = findViewById(R.id.etRegisterPassword);
        etPasswordConfirm = findViewById(R.id.etRegisterPasswordConfirm);
        btnRegister = findViewById(R.id.btnRegister);
        loginLink = findViewById(R.id.loginLink);

        repo = FakeRepository.getInstance();

        btnRegister.setOnClickListener(v -> registerUser());

        loginLink.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });
    }

    private void registerUser() {

        String email = etEmail.getText().toString().trim();
        String emailConfirm = etEmailConfirm.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String passwordConfirm = etPasswordConfirm.getText().toString().trim();

        if (email.isEmpty() || emailConfirm.isEmpty()
                || password.isEmpty() || passwordConfirm.isEmpty()) {

            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!email.equals(emailConfirm)) {
            Toast.makeText(this, "Los correos no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(passwordConfirm)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        for (User u : repo.getUsers()) {
            if (u.getEmail().equals(email)) {
                Toast.makeText(this, "Este correo ya está registrado", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        User newUser = new User(email, password, "");
        repo.addUser(newUser);

        Toast.makeText(this, "Cuenta creada. Inicia sesión", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
}
