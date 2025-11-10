package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Videojuego;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para acceder a los videojuegos en la base de datos.
 * Se encarga de obtener todos los registros de la tabla "videojuegos".
 */
public class VideojuegoRepository {

    private final DBConnector dbConnector;

    /**
     * Constructor que recibe un conector a la base de datos.
     */
    public VideojuegoRepository(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    /**
     * Obtiene todos los videojuegos de la base de datos.
     * @return Lista de objetos Videojuego.
     */
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
