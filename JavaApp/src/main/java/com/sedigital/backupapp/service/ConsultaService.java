package com.sedigital.backupapp.service;

import com.sedigital.backupapp.repository.BaseRepository;

import java.util.List;

/**
 * Servicio que consulta y muestra información de todas las tablas.
 */
public class ConsultaService {

    private final List<BaseRepository<?>> repositorios;

    public ConsultaService(List<BaseRepository<?>> repositorios) {
        this.repositorios = repositorios;
    }

    /**
     * Muestra todos los registros de la tabla indicada por su nombre.
     * @param nombreTabla nombre de la tabla a mostrar
     */
    public void mostrarTabla(String nombreTabla) {
        for (BaseRepository<?> repo : repositorios) {
            if (repo.getNombreTabla().equals(nombreTabla)) {
                List<?> registros = repo.findAll();
                System.out.println("=== " + nombreTabla + " ===");
                for (Object registro : registros) {
                    System.out.println(registro);
                }
                return;
            }
        }
        System.out.println("No se encontró la tabla: " + nombreTabla);
    }
}
