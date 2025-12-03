package com.sedigital.backupapp.model;

/**
 * Representa una categoría de videojuegos.
 */
public class Categoria {
    private int id;
    private String nombre;

    /**
     * Constructor completo de Categoria.
     */
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /** Getters y setters */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
