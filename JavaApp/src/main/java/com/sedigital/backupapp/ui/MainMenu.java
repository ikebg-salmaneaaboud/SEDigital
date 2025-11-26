package com.sedigital.backupapp.ui;

import com.sedigital.backupapp.service.ConsultaService;
import com.sedigital.backupapp.service.ExportService;
import com.sedigital.backupapp.utils.InputReader;

/**
 * Menú principal de la aplicación, basado en consola.
 * <p>
 * Permite al usuario consultar datos almacenados en la base de datos
 * y ejecutar la exportación completa de las tablas a archivos XML.
 */
public class MainMenu {

    private static final String EXPORT_PATH = "./backups";

    private final ConsultaService consultaService;
    private final ExportService exportService;

    /**
     * Construye el menú principal recibiendo los servicios necesarios.
     *
     * @param consultaService servicio encargado de las consultas a la base de datos
     * @param exportService   servicio encargado de la exportación de datos
     */
    public MainMenu(ConsultaService consultaService, ExportService exportService) {
        this.consultaService = consultaService;
        this.exportService = exportService;
    }

    /**
     * Inicia el ciclo del menú principal.
     * <p>
     * Muestra las opciones disponibles, espera la selección del usuario
     * y ejecuta la acción correspondiente. Termina cuando se elige "Salir".
     */
    public void iniciar() {
        String[] opciones = {
                "Ver Videojuegos",
                "Ver Proveedores",
                "Ver Plataformas",
                "Exportar todas las tablas a XML",
                "Salir"
        };

        int opcion;

        do {
            opcion = mostrarOpcionesYLeerSeleccion("Menú Principal", opciones);

            switch (opcion) {
                case 1 -> consultaService.mostrarVideojuegos();
                case 2 -> consultaService.mostrarProveedores();
                case 3 -> consultaService.mostrarPlataformas();
                case 4 -> ejecutarExportacion();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    /**
     * Muestra el menú recibido y solicita la opción al usuario.
     *
     * @param titulo   título para mostrar sobre el menú
     * @param opciones lista de opciones a mostrar
     * @return número de opción seleccionado por el usuario
     */
    private int mostrarOpcionesYLeerSeleccion(String titulo, String[] opciones) {
        System.out.println("\n=== " + titulo + " ===");

        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }

        return InputReader.readInt("Selecciona una opción: ");
    }

    /**
     * Ejecuta la exportación de todas las tablas a XML
     * y muestra un mensaje de confirmación.
     */
    private void ejecutarExportacion() {
        exportService.exportarTodos(EXPORT_PATH);
        System.out.println("Exportación completada.");
    }
}
