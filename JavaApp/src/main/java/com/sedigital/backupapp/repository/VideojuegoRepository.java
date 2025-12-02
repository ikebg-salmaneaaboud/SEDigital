package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Videojuego;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para acceder a los datos de la tabla "videojuegos".
 * <p>
 * Extiende {@link BaseRepository} para reutilizar la gestión del conector
 * a la base de datos y el nombre de la tabla. Implementa el método
 * {@link #findAll()} para obtener todos los registros de videojuegos
 * y mapearlos a objetos {@link Videojuego}.
 */
public class VideojuegoRepository extends BaseRepository<Videojuego> {

    /**
     * Constructor que inicializa el repositorio con el conector a la base de datos.
     *
     * @param dbConnector Conector a la base de datos.
     */
    public VideojuegoRepository(DBConnector dbConnector) {
        super(dbConnector, "videojuegos");
    }

    /**
     * Obtiene todos los registros de la tabla "videojuegos".
     * <p>
     * Cada fila se convierte en un objeto {@link Videojuego} con sus campos correspondientes:
     *
     * @return Lista de objetos {@link Videojuego} que representan los registros de la tabla.
     */
    @Override
    public List<Videojuego> findAll() {
        List<Videojuego> data = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos";

        try (Statement st = dbConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                data.add(new Videojuego(
                        rs.getInt("id_videojuego"),
                        rs.getInt("unidad"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getFloat("precio_base"),
                        rs.getInt("es_digital"),
                        rs.getString("clasificacion"),
                        rs.getDate("fecha_lanzamiento"),
                        rs.getInt("id_proveedor")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
