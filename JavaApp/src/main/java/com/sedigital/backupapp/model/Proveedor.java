package com.sedigital.backupapp.model;

/**
 * Representa un proveedor en la base de datos.
 */
public class Proveedor {
    private int id_proveedor;
    private String nombre;
    private String email;
    private int telefono;

    /**
     * Constructor completo de Proveedor.
     */
    public Proveedor(int id_proveedor, String nombre, String email, int telefono) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    /** Getters y setters */

    public int getId_proveedor() { return id_proveedor; }
    public void setId_proveedor(int id_proveedor) { this.id_proveedor = id_proveedor; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id_proveedor=" + id_proveedor +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
