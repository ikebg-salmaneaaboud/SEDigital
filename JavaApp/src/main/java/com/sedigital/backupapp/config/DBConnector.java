package com.sedigital.backupapp.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    private String dbName;
    private String user;
    private String pass;
    private String dbUrl;

    public DBConnector() {
        cargarConfiguracion();
    }

    private void cargarConfiguracion() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            this.dbName = props.getProperty("db.name");
            this.user = props.getProperty("db.user");
            this.pass = props.getProperty("db.pass");
            this.dbUrl = props.getProperty("db.url");
        } catch (IOException e) {
            System.out.println("Error cargando archivo config.properties");
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver no encontrado.");
            e.printStackTrace();
        }
        return DriverManager.getConnection(dbUrl, user, pass);
    }
}
