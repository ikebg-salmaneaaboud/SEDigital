package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Plataforma;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para acceder a las plataformas de videojuegos en la base de datos.
 */
public class PlataformaRepository {

    private final DBConnector dbConnector;

    /**
     * Constructor que recibe un conector a la base de datos.
     */
    public PlataformaRepository(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    /**
     * Obtiene todas las plataformas de la base de datos.
     * @return Lista de objetos Plataforma.
     */
    public List<Plataforma> findAll() {
        List<Plataforma> plataformas = new ArrayList<>();
        String sql = "SELECT * FROM plataformas";

        try (Statement st = dbConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Plataforma p = new Plataforma(
                        rs.getInt("id_plataforma"),
                        rs.getString("nombre")
                );
                plataformas.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plataformas;
    }
}
