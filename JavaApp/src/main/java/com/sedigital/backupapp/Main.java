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

public class Main {

    public static void main(String[] args) {
        DBConnector db = new DBConnector();

        List<BaseRepository<?>> repos = List.of(
                new VideojuegoRepository(db),
                new ProveedorRepository(db),
                new PlataformaRepository(db)
        );

        // Servicio de consultas
        ConsultaService consultaService = new ConsultaService(repos);

        // Servicio de exportación de XMLs
        XMLExporter xmlExporter = new XMLExporter();

        ExportService exportService = new ExportService(xmlExporter, repos);

        MainMenu menu = new MainMenu(consultaService, exportService);
        menu.iniciar();
    }
}
