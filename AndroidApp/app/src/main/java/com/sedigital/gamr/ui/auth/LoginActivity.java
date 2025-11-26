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

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private MaterialButton btnConfirmLogin;
    private TextView registerLink;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnConfirmLogin = findViewById(R.id.btnConfirmLogin);
        registerLink = findViewById(R.id.tvRegister);

        users = FakeRepository.getInstance().getUsers();

        btnConfirmLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingresa email y contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            User matchedUser = null;
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    matchedUser = user;
                    break;
                }
            }

            if (matchedUser != null) {
                Toast.makeText(this, "Bienvenido " + matchedUser.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, CatalogActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        registerLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}
