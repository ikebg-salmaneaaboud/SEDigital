package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Plataforma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para acceder a los datos de la tabla "plataformas".
 * <p>
 * Extiende {@link BaseRepository} para reutilizar la gestión del conector
 * a la base de datos y el nombre de la tabla. Implementa el método
 * {@link #findAll()} para obtener todos los registros de plataformas
 * y mapearlos a objetos {@link Plataforma}.
 */
public class PlataformaRepository extends BaseRepository<Plataforma> {

    /**
     * Constructor que inicializa el repositorio con el conector a la base de datos.
     *
     * @param dbConnector Conector a la base de datos.
     */
    public PlataformaRepository(DBConnector dbConnector) {
        super(dbConnector, "plataformas");
    }

    /**
     * Obtiene todos los registros de la tabla "plataformas".
     * <p>
     * Cada fila se convierte en un objeto {@link Plataforma} con sus campos correspondientes.
     *
     * @return Lista de objetos {@link Plataforma} que representan los registros de la tabla.
     */
    @Override
    public List<Plataforma> findAll() {
        List<Plataforma> plataformas = new ArrayList<>();
        String sql = "SELECT * FROM plataformas";

        try (Statement st = dbConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                plataformas.add(new Plataforma(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plataformas;
    }
}
