package com.sedigital.backupapp;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.repository.PlataformaRepository;
import com.sedigital.backupapp.repository.ProveedorRepository;
import com.sedigital.backupapp.repository.VideojuegoRepository;
import com.sedigital.backupapp.service.ExportService;
import com.sedigital.backupapp.xml.XMLExporter;

/**
 * Clase principal que ejecuta el programa de exportación de tablas a XML.
 */
public class Main {

    /**
     * Método principal.
     * Crea los repositorios, el exportador y el servicio de exportación,
     * y ejecuta la exportación de todas las tablas al directorio "./backups".
     *
     * @param args Argumentos de línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();

        VideojuegoRepository videojuegoRepo = new VideojuegoRepository(dbConnector);
        ProveedorRepository proveedorRepo = new ProveedorRepository(dbConnector);
        PlataformaRepository plataformaRepo = new PlataformaRepository(dbConnector);

        XMLExporter xmlExporter = new XMLExporter();

        ExportService exportService = new ExportService(xmlExporter,
                videojuegoRepo,
                proveedorRepo,
                plataformaRepo);

        exportService.exportarTodos("./backups");

        System.out.println("Exportación completada. Archivos generados en ./backups");
    }
}
