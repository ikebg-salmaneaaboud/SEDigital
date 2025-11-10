package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Videojuego;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VideojuegoRepository {
    private final DBConnector dbConnector;

    public VideojuegoRepository(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public List<Videojuego> findAll() {
        List<Videojuego> data = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos";

        try (Statement st = dbConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Videojuego v = new Videojuego(
                        rs.getInt("id_videojuego"),
                        rs.getInt("unidad"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getFloat("precio_base"),
                        rs.getInt("es_digital"),
                        rs.getString("clasificacion"),
                        rs.getDate("fecha_lanzamiento"),
                        rs.getInt("id_proveedor")
                );
                data.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
