package com.sedigital.backupapp.model;

public class Plataforma {
    private int id_plataforma;
    private String nombre;

    public Plataforma(int id_plataforma, String nombre) {
        this.id_plataforma = id_plataforma;
        this.nombre = nombre;
    }

    public int getId_plataforma() {
        return id_plataforma;
    }

    public void setId_plataforma(int id_plataforma) {
        this.id_plataforma = id_plataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "id_plataforma=" + id_plataforma +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
