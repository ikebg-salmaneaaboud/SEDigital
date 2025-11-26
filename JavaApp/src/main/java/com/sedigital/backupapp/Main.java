package com.sedigital.backupapp;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.repository.PlataformaRepository;
import com.sedigital.backupapp.repository.ProveedorRepository;
import com.sedigital.backupapp.repository.VideojuegoRepository;
import com.sedigital.backupapp.service.ConsultaService;
import com.sedigital.backupapp.service.ExportService;
import com.sedigital.backupapp.ui.MainMenu;
import com.sedigital.backupapp.xml.XMLExporter;

/**
 * Punto de entrada de la aplicación.
 * <p>
 * Inicializa la conexión a la base de datos, crea los repositorios necesarios,
 * los servicios de consulta y exportación, y lanza la interfaz de menú para
 * interactuar con el sistema.
 */
public class Main {

    /**
     * Método principal de ejecución de la aplicación.
     * <p>
     * Realiza los siguientes pasos:
     * <ul>
     *   <li>Inicializa la conexión a la base de datos mediante {@link DBConnector}.</li>
     *   <li>Crea los repositorios de videojuegos, proveedores y plataformas.</li>
     *   <li>Instancia el servicio de consultas {@link ConsultaService}.</li>
     *   <li>Configura el exportador XML y el servicio de exportación {@link ExportService}.</li>
     *   <li>Inicia la interfaz textual del menú principal {@link MainMenu}.</li>
     * </ul>
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        DBConnector db = new DBConnector();

        VideojuegoRepository vRepo = new VideojuegoRepository(db);
        ProveedorRepository pRepo = new ProveedorRepository(db);
        PlataformaRepository plRepo = new PlataformaRepository(db);

        ConsultaService consultaService = new ConsultaService(vRepo, pRepo, plRepo);
        XMLExporter xmlExporter = new XMLExporter();
        ExportService exportService = new ExportService(xmlExporter, vRepo, pRepo, plRepo);

        MainMenu menu = new MainMenu(consultaService, exportService);
        menu.iniciar();
    }
}
