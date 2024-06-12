package org.example.ej5_procesadores;

public class Tarea implements Comparable{

    private String nombre;
    private int tiempo_ejecucion;

    public Tarea(String nombre, int tiempo_ejecucion) {
        this.nombre = nombre;
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public String getNombre() {
        return nombre;
    }

//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }

    public int getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }

    @Override
    public int compareTo(Object o) {
        Tarea t = (Tarea) o;
        if(this.tiempo_ejecucion > t.tiempo_ejecucion){
            return 1;
        } else if(this.tiempo_ejecucion < t.tiempo_ejecucion){
            return -1;
        }
        return 0;
    }

//    public void setTiempo_ejecucion(int tiempo_ejecucion) {
//        this.tiempo_ejecucion = tiempo_ejecucion;
//    }


}
