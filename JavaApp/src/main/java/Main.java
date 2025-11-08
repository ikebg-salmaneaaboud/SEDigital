import database.DBConnector;
import database.DataAccessObject;
import service.ExportService;
import xml.XMLExporter;

import java.util.List;

/**
 * Clase principal que ejecuta el programa
 */
public class Main {
    /**
     * Método princiapl.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        List<String> nombreTablas = List.of("videojuegos", "proveedores");
        DBConnector dbConnector = new DBConnector();
        DataAccessObject dataAccessObject = new DataAccessObject(dbConnector);
        XMLExporter xmlExporter = new XMLExporter();
        ExportService exportService = new ExportService(dataAccessObject, xmlExporter, nombreTablas);
        exportService.exportarTablas();
    }
}
