package com.sedigital.backupapp.service;

import com.sedigital.backupapp.repository.BaseRepository;
import com.sedigital.backupapp.xml.XMLExporter;

import java.io.File;
import java.util.List;

/**
 * Servicio que exporta los datos de múltiples repositorios a archivos XML.
 * <p>
 * Permite manejar cualquier repositorio que implemente {@link BaseRepository}
 * de manera genérica, creando un archivo XML por cada tabla.
 */
public class ExportService {

    /** Componente que realiza la generación de archivos XML. */
    private final XMLExporter exporter;

    /** Lista de repositorios cuyas tablas se van a exportar. */
    private final List<BaseRepository<?>> repositorios;

    /**
     * Inicializa el servicio con el exportador y la lista de repositorios.
     *
     * @param exporter     Exportador XML.
     * @param repositorios Repositorios a exportar.
     */
    public ExportService(XMLExporter exporter, List<BaseRepository<?>> repositorios) {
        this.exporter = exporter;
        this.repositorios = repositorios;
    }

    /**
     * Exporta todas las tablas de los repositorios a XML en el directorio indicado.
     * <p>
     * Cada repositorio genera un archivo separado con el nombre de su tabla.
     *
     * @param outputDir Ruta del directorio donde se guardarán los XML.
     */
    public void exportarTodos(String outputDir) {
        for (BaseRepository<?> repo : repositorios) {
            String path = outputDir + "/" + repo.getNombreTabla() + ".xml";
            File file = new File(path);
            file.getParentFile().mkdirs();
            exporter.exportarTabla(repo.getNombreTabla(), repo.findAll(), path);
        }
    }
}
