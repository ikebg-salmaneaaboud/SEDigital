package com.sedigital.backupapp.model;

import java.sql.Date;

/**
 * Representa un videojuego en la base de datos.
 * Contiene información básica como título, precio, clasificación y proveedor.
 */
public class Videojuego {
    private int id;
    private int unidad;
    private String titulo;
    private String descripcion;
    private float precio_base;
    private int es_digital;
    private String clasificacion;
    private Date fecha_lanzamiento;
    private int id_proveedor;

    /**
     * Constructor completo de Videojuego.
     */
    public Videojuego(int id, int unidad, String titulo, String descripcion, float precio_base, int es_digital, String clasificacion, Date fecha_lanzamiento, int id_proveedor) {
        this.id = id;
        this.unidad = unidad;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio_base = precio_base;
        this.es_digital = es_digital;
        this.clasificacion = clasificacion;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.id_proveedor = id_proveedor;
    }

    /** Getters y setters */

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUnidad() { return unidad; }
    public void setUnidad(int unidad) { this.unidad = unidad; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public float getPrecio_base() { return precio_base; }
    public void setPrecio_base(float precio_base) { this.precio_base = precio_base; }
    public int getEs_digital() { return es_digital; }
    public void setEs_digital(int es_digital) { this.es_digital = es_digital; }
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
    public Date getFecha_lanzamiento() { return fecha_lanzamiento; }
    public void setFecha_lanzamiento(Date fecha_lanzamiento) { this.fecha_lanzamiento = fecha_lanzamiento; }
    public int getId_proveedor() { return id_proveedor; }
    public void setId_proveedor(int id_proveedor) { this.id_proveedor = id_proveedor; }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id_videojuego=" + id +
                ", unidad=" + unidad +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio_base=" + precio_base +
                ", es_digital=" + es_digital +
                ", clasificacion='" + clasificacion + '\'' +
                ", fecha_lanzamiento=" + fecha_lanzamiento +
                ", id_proveedor=" + id_proveedor +
                '}';
    }
}
