package com.sedigital.backupapp.config;
import java.sql.*;

/**
 * Clase que maneja la conexión a la base de datos MySQL.
 */
public class DBConnector {
    private final String DB_NAME = "tienda_videojuegos";
    private final String USER = "root";
    private final String PASS = "2dam3";
    private final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private Connection connection;

    /**
     * Constructor que establece la conexión automáticamente.
     */
    public DBConnector() {
        connect();
    }

    /**
     * Establece la conexión a la base de datos.
     */
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene la conexión activa.
     * @return instancia de Connection.
     */
    public Connection getConnection() {
        return connection;
    }
}
