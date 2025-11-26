package com.sedigital.backupapp.ui;

import com.sedigital.backupapp.service.ConsultaService;
import com.sedigital.backupapp.service.ExportService;
import com.sedigital.backupapp.utils.InputReader;

public class MenuUI {

    private final ConsultaService consultaService;
    private final ExportService exportService;

    public MenuUI(ConsultaService consultaService, ExportService exportService) {
        this.consultaService = consultaService;
        this.exportService = exportService;
    }

    public void mostrarMenu() {
        String[] opciones = { "Ver Videojuegos", "Ver Proveedores", "Ver Plataformas",
                "Exportar todas las tablas a XML", "Salir" };
        int opcion;
        do {
            opcion = mostrarMenuYLeerOpcion("Menú Principal", opciones);
            switch (opcion) {
                case 1 -> consultaService.mostrarVideojuegos();
                case 2 -> consultaService.mostrarProveedores();
                case 3 -> consultaService.mostrarPlataformas();
                case 4 -> {
                    String ruta = "./backups";
                    exportService.exportarTodos(ruta);
                    System.out.println("Exportación completada.");
                }
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    private int mostrarMenuYLeerOpcion(String titulo, String[] opciones) {
        System.out.println("\n=== " + titulo + " ===");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        return InputReader.readInt("Selecciona una opción: ");
    }
}
