package com.sedigital.gamr.data.mock;

import com.sedigital.gamr.data.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Proveedor de datos simulados para usuarios.
 * Retorna una lista predefinida de usuarios para pruebas de autenticación.
 */
public class UserProvider {

    /**
     * Retorna una lista de usuarios simulados.
     * Cada usuario contiene email, contraseña y nombre.
     * @return lista de User
     */
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        // Usuario de prueba
        users.add(new User("test", "123", "Test User"));

        // Usuario administrador
        users.add(new User("admin@example.com", "admin123", "Admin"));

        // Usuario jugador
        users.add(new User("player@example.com", "playerpass", "Player One"));

        return users;
    }
}
