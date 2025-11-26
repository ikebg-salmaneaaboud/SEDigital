package com.sedigital.backupapp.service;

import com.sedigital.backupapp.model.Videojuego;
import com.sedigital.backupapp.model.Proveedor;
import com.sedigital.backupapp.model.Plataforma;
import com.sedigital.backupapp.repository.VideojuegoRepository;
import com.sedigital.backupapp.repository.ProveedorRepository;
import com.sedigital.backupapp.repository.PlataformaRepository;

import java.util.List;

public class ConsultaService {
    private final VideojuegoRepository videojuegoRepo;
    private final ProveedorRepository proveedorRepo;
    private final PlataformaRepository plataformaRepo;

    public ConsultaService(VideojuegoRepository vRepo,
                           ProveedorRepository pRepo,
                           PlataformaRepository plRepo) {
        this.videojuegoRepo = vRepo;
        this.proveedorRepo = pRepo;
        this.plataformaRepo = plRepo;
    }

    public void mostrarVideojuegos() {
        List<Videojuego> list = videojuegoRepo.findAll();
        list.forEach(v -> System.out.println(v.getId_videojuego() + " | " + v.getTitulo() + " | " + v.getPrecio_base()));
    }

    public void mostrarProveedores() {
        List<Proveedor> list = proveedorRepo.findAll();
        list.forEach(p -> System.out.println(p.getId_proveedor() + " | " + p.getNombre() + " | " + p.getEmail()));
    }

    public void mostrarPlataformas() {
        List<Plataforma> list = plataformaRepo.findAll();
        list.forEach(p -> System.out.println(p.getId_plataforma() + " | " + p.getNombre()));
    }
}
