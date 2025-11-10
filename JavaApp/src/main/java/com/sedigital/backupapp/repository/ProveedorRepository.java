package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Proveedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorRepository {
    private final DBConnector dbConnector;

    public ProveedorRepository(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

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
