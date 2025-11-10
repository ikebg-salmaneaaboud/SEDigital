package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Proveedor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para acceder a los proveedores en la base de datos.
 */
public class ProveedorRepository {

    private final DBConnector dbConnector;

    /**
     * Constructor que recibe un conector a la base de datos.
     */
    public ProveedorRepository(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    /**
     * Obtiene todos los proveedores de la base de datos.
     * @return Lista de objetos Proveedor.
     */
    public List<Proveedor> findAll() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try (Statement st = dbConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Proveedor p = new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("telefono")
                );
                proveedores.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedores;
    }
}
