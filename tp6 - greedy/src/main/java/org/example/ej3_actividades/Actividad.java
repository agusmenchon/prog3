package org.example.ej3_actividades;

public class Actividad {

    private String nombre;
    private double tiempo_inicio;
    private double tiempo_fin;

    public Actividad(String nombre, double tiempo_inicio, double tiempo_fin) {
        this.nombre = nombre;
        this.tiempo_inicio = tiempo_inicio;
        this.tiempo_fin = tiempo_fin;
    }

    public double getTiempo_inicio() {
        return tiempo_inicio;
    }

    public double getTiempo_fin() {
        return tiempo_fin;
    }

    public String getNombre() {
        return nombre;
    }
}
