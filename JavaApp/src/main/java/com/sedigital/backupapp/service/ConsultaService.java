package com.sedigital.backupapp.service;

import com.sedigital.backupapp.model.Videojuego;
import com.sedigital.backupapp.model.Proveedor;
import com.sedigital.backupapp.model.Plataforma;
import com.sedigital.backupapp.repository.VideojuegoRepository;
import com.sedigital.backupapp.repository.ProveedorRepository;
import com.sedigital.backupapp.repository.PlataformaRepository;

import java.util.List;

/**
 * Servicio encargado de consultar y mostrar información básica
 * de videojuegos, proveedores y plataformas disponibles en el sistema.
 */
public class ConsultaService {
    private final VideojuegoRepository videojuegoRepo;
    private final ProveedorRepository proveedorRepo;
    private final PlataformaRepository plataformaRepo;

    /**
     * Construye una instancia del servicio utilizando los repositorios necesarios.
     *
     * @param vRepo  repositorio para operaciones relacionadas con {@link Videojuego}
     * @param pRepo  repositorio para operaciones relacionadas con {@link Proveedor}
     * @param plRepo repositorio para operaciones relacionadas con {@link Plataforma}
     */
    public ConsultaService(VideojuegoRepository vRepo,
                           ProveedorRepository pRepo,
                           PlataformaRepository plRepo) {
        this.videojuegoRepo = vRepo;
        this.proveedorRepo = pRepo;
        this.plataformaRepo = plRepo;
    }

    /**
     * Obtiene todos los videojuegos registrados y muestra por consola
     * su identificador, título y precio base.
     */
    public void mostrarVideojuegos() {
        List<Videojuego> list = videojuegoRepo.findAll();
        list.forEach(v ->
                System.out.println(v.getId_videojuego() + " | " + v.getTitulo() + " | " + v.getPrecio_base()));
    }

    /**
     * Obtiene todos los proveedores registrados y muestra por consola
     * su identificador, nombre y correo electrónico.
     */
    public void mostrarProveedores() {
        List<Proveedor> list = proveedorRepo.findAll();
        list.forEach(p ->
                System.out.println(p.getId_proveedor() + " | " + p.getNombre() + " | " + p.getEmail()));
    }

    /**
     * Obtiene todas las plataformas registradas y muestra por consola
     * su identificador y nombre.
     */
    public void mostrarPlataformas() {
        List<Plataforma> list = plataformaRepo.findAll();
        list.forEach(p ->
                System.out.println(p.getId_plataforma() + " | " + p.getNombre()));
    }
}
