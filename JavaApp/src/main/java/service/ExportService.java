package service;

import database.DataAccessObject;
import xml.XMLExporter;

import java.util.List;
import java.util.Map;

/**
 * Servicio para exportar tablas a archivos XML.
 */
public class ExportService {
    private final DataAccessObject dao;
    private final XMLExporter exporter;
    private final List<String> nombreTablas;

    /**
     * Constructor que inicializa el servicio con DAO, exportador y lista de tablas.
     * @param dao instancia de acceso a datos.
     * @param exporter instancia para exportar XML.
     * @param nombreTablas lista de nombres de tablas a exportar.
     */
    public ExportService(DataAccessObject dao, XMLExporter exporter, List<String> nombreTablas) {
        this.dao = dao;
        this.exporter = exporter;
        this.nombreTablas = nombreTablas;
    }

    /**
     * Exporta las tablas especificadas a archivos XML.
     */
    public void exportarTablas() {
//        Si queremos todas las tablas
//        List<String> tablas = dao.getTableNames();

        for (String nombreTabla : nombreTablas) {
            List<Map<String, Object>> datos = dao.getTableData(nombreTabla);
            exporter.exportarTabla(
                    nombreTabla,
                    datos,
                    "./output/" + nombreTabla + ".xml"
            );
        }
    }
}
