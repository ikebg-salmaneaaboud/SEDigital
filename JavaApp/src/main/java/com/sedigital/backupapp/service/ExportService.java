package com.sedigital.backupapp.service;

import com.sedigital.backupapp.model.Plataforma;
import com.sedigital.backupapp.model.Proveedor;
import com.sedigital.backupapp.model.Videojuego;
import com.sedigital.backupapp.repository.PlataformaRepository;
import com.sedigital.backupapp.repository.ProveedorRepository;
import com.sedigital.backupapp.repository.VideojuegoRepository;
import com.sedigital.backupapp.xml.XMLExporter;

import java.util.List;

/**
 * Servicio que centraliza la exportación de todas las tablas a XML.
 * No utiliza generics ni lógica complicada, para mantenerlo legible.
 */
public class ExportService {

    private final XMLExporter exporter;
    private final VideojuegoRepository videojuegoRepo;
    private final ProveedorRepository proveedorRepo;
    private final PlataformaRepository plataformaRepo;

    /**
     * Constructor que recibe el exportador y los repositorios.
     *
     * @param exporter        Instancia de XMLExporter.
     * @param videojuegoRepo  Repositorio de Videojuego.
     * @param proveedorRepo   Repositorio de Proveedor.
     * @param plataformaRepo  Repositorio de Plataforma.
     */
    public ExportService(XMLExporter exporter,
                         VideojuegoRepository videojuegoRepo,
                         ProveedorRepository proveedorRepo,
                         PlataformaRepository plataformaRepo) {
        this.exporter = exporter;
        this.videojuegoRepo = videojuegoRepo;
        this.proveedorRepo = proveedorRepo;
        this.plataformaRepo = plataformaRepo;
    }

    /**
     * Exporta todas las tablas a archivos XML en la ruta indicada.
     * Cada tabla se exporta con un archivo separado.
     *
     * @param outputDir Directorio donde se guardarán los XML.
     */
    public void exportarTodos(String outputDir) {
        exporter.exportarTabla("videojuegos", videojuegoRepo.findAll(), outputDir + "/videojuegos.xml");
        exporter.exportarTabla("proveedores", proveedorRepo.findAll(), outputDir + "/proveedores.xml");
        exporter.exportarTabla("plataformas", plataformaRepo.findAll(), outputDir + "/plataformas.xml");
    }
}
