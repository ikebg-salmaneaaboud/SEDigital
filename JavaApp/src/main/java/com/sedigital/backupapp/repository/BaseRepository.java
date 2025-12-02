package com.sedigital.backupapp.repository;

import com.sedigital.backupapp.config.DBConnector;
import java.util.List;

/**
 * Clase base abstracta para repositorios de acceso a base de datos.
 * <p>
 * Gestiona un conector a la base de datos y almacena el nombre de la tabla
 * asociada. Cada repositorio concreto debe extender esta clase e implementar
 * {@link #findAll()} para devolver los registros específicos de su entidad.
 *
 * @param <T> Tipo de entidad gestionada por el repositorio (por ejemplo, Videojuego, Plataforma, Proveedor)
 */
public abstract class BaseRepository<T> {

    /** Conector a la base de datos utilizado por el repositorio. */
    protected final DBConnector dbConnector;

    /** Nombre de la tabla asociada al repositorio. */
    private final String tableName;

    /**
     * Inicializa el repositorio con un conector y el nombre de la tabla.
     *
     * @param dbConnector Conector a la base de datos.
     * @param tableName   Nombre de la tabla asociada.
     */
    protected BaseRepository(DBConnector dbConnector, String tableName) {
        this.dbConnector = dbConnector;
        this.tableName = tableName;
    }

    /**
     * Devuelve el nombre de la tabla asociada al repositorio.
     *
     * @return Nombre de la tabla.
     */
    public String getNombreTabla() {
        return tableName;
    }

    /**
     * Obtiene todos los registros de la tabla y los mapea a objetos del tipo {@code T}.
     * <p>
     * Cada subclase debe proporcionar la implementación concreta según su entidad.
     *
     * @return Lista de objetos {@code T} representando los registros de la tabla.
     */
    public abstract List<T> findAll();
}
