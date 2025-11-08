package database;

import java.sql.*;
import java.util.*;

/**
 * Clase que maneja el acceso a datos de la base de datos
 * Proporciona métodos para obtener nombres de tablas y datos
 */
public class DataAccessObject {
    private final DBConnector dbConnector;

    /**
     * Constructor que recibe un conector a la base de datos.
     * @param dbConnector
     */
    public DataAccessObject(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    /**
     * Obtiene la lista de nombres de tablas de la base de datos.
     * @return Lista de nombres de tablas.
     */
    public List<String> getTableNames() {
        List<String> tables = new ArrayList<>();
        try {
            Connection conn = dbConnector.getConnection();
            DatabaseMetaData meta = conn.getMetaData();
            String catalog = conn.getCatalog();

            ResultSet rs = meta.getTables(catalog, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    /**
     * Obtiene todos los datos de una tabla específica
     * @param tableName nombre de la tabla.
     * @return Lista de mapas, donde cada mapa representa una fila con nombre de columna y valor.
     */
    public List<Map<String, Object>> getTableData(String tableName) {
        List<Map<String, Object>> data = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;

        try (Statement st = dbConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(meta.getColumnName(i), rs.getObject(i));
                }
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
