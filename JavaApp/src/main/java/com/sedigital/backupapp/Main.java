package com.sedigital.backupapp;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.repository.PlataformaRepository;
import com.sedigital.backupapp.repository.ProveedorRepository;
import com.sedigital.backupapp.repository.VideojuegoRepository;
import com.sedigital.backupapp.service.ConsultaService;
import com.sedigital.backupapp.service.ExportService;
import com.sedigital.backupapp.ui.MenuUI;
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
        DBConnector db = new DBConnector();

        VideojuegoRepository vRepo = new VideojuegoRepository(db);
        ProveedorRepository pRepo = new ProveedorRepository(db);
        PlataformaRepository plRepo = new PlataformaRepository(db);

        ConsultaService consultaService = new ConsultaService(vRepo, pRepo, plRepo);
        XMLExporter xmlExporter = new XMLExporter();
        ExportService exportService = new ExportService(xmlExporter, vRepo, pRepo, plRepo);

        MenuUI menu = new MenuUI(consultaService, exportService);
        menu.mostrarMenu();
    }
}
