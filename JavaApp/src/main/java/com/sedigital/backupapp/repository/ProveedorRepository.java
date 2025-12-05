package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.model.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para acceder a los datos de la tabla "proveedores".
 * <p>
 * Extiende {@link BaseRepository} para reutilizar la gestión del conector
 * a la base de datos y el nombre de la tabla. Implementa el método
 * {@link #findAll()} para obtener todos los registros de proveedores
 * y mapearlos a objetos {@link Proveedor}.
 */
public class ProveedorRepository extends BaseRepository<Proveedor> {

    /**
     * Constructor que inicializa el repositorio con el conector a la base de datos.
     *
     * @param dbConnector Conector a la base de datos.
     */
    public ProveedorRepository(DBConnector dbConnector) {
        super(dbConnector, "proveedores");
    }

    /**
     * Obtiene todos los registros de la tabla "proveedores".
     * <p>
     * Cada fila se convierte en un objeto {@link Proveedor} con sus campos correspondientes.
     *
     * @return Lista de objetos {@link Proveedor} que representan los registros de la tabla.
     */
    @Override
    public List<Proveedor> findAll() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try (Statement st = dbConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                proveedores.add(new Proveedor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("telefono")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedores;
    }
}
