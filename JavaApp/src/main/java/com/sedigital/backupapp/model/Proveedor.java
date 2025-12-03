package com.sedigital.backupapp.model;

/**
 * Representa un proveedor en la base de datos.
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String email;
    private int telefono;

    /**
     * Constructor completo de Proveedor.
     */
    public Proveedor(int id, String nombre, String email, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    /** Getters y setters */

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id_proveedor=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
