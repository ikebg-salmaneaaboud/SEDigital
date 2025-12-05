package com.sedigital.backupapp;

import com.sedigital.backupapp.config.DBConnector;
import com.sedigital.backupapp.repository.BaseRepository;
import com.sedigital.backupapp.repository.PlataformaRepository;
import com.sedigital.backupapp.repository.ProveedorRepository;
import com.sedigital.backupapp.repository.VideojuegoRepository;
import com.sedigital.backupapp.service.ConsultaService;
import com.sedigital.backupapp.service.ExportService;
import com.sedigital.backupapp.ui.MainMenu;
import com.sedigital.backupapp.xml.XMLExporter;

import java.util.List;

/**
 * Clase principal de la aplicación BackupApp.
 *
 * Esta clase se encarga de inicializar la conexión a la base de datos,
 * los repositorios, los servicios de consulta y exportación, y la interfaz
 * de usuario principal.
 *
 * Dependencias:
 * <ul>
 *   <li>{@link com.sedigital.backupapp.config.DBConnector} - para la conexión a la base de datos.</li>
 *   <li>Repositorios: {@link com.sedigital.backupapp.repository.VideojuegoRepository},
 *   {@link com.sedigital.backupapp.repository.ProveedorRepository},
 *   {@link com.sedigital.backupapp.repository.PlataformaRepository} - acceso a datos.</li>
 *   <li>Servicios: {@link com.sedigital.backupapp.service.ConsultaService},
 *   {@link com.sedigital.backupapp.service.ExportService} - lógica de negocio.</li>
 *   <li>{@link com.sedigital.backupapp.ui.MainMenu} - interfaz de usuario.</li>
 *   <li>{@link com.sedigital.backupapp.xml.XMLExporter} - exportación de datos a XML.</li>
 * </ul>
 */
public class Main {

    /**
     * Punto de entrada de la aplicación.
     * <p>
     * Inicializa la conexión a la base de datos, los repositorios, los servicios
     * de consulta y exportación, y la interfaz de usuario principal.
     * </p>
     *
     * @param args argumentos de línea de comandos (no se utilizan actualmente)
     */
    public static void main(String[] args) {
        DBConnector db = new DBConnector();

        List<BaseRepository<?>> repos = List.of(
                new VideojuegoRepository(db),
                new ProveedorRepository(db),
                new PlataformaRepository(db)
        );

        ConsultaService consultaService = new ConsultaService(repos);

        XMLExporter xmlExporter = new XMLExporter();

        ExportService exportService = new ExportService(xmlExporter, repos);

        MainMenu menu = new MainMenu(consultaService, exportService);
        menu.iniciar();
    }
}

