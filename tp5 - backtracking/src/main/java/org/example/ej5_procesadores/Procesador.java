package org.example.ej5_procesadores;

import java.util.ArrayList;

public class Procesador {

    private String nombre;
    private ArrayList<Tarea> tareas;
    private Integer tiempo_ejecucioActual;

    public Procesador(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
        tiempo_ejecucioActual = 0;
    }

    public void addTarea(Tarea t){
        this.tareas.add(t);
        this.tiempo_ejecucioActual += t.getTiempo_ejecucion();
//        if(tiempo_ejecucioActual == Integer.MAX_VALUE){
//            this.tiempo_ejecucioActual = t.getTiempo_ejecucion();
//        } else{
//        }
    }

    public void deleteTarea(Tarea t){
        this.tareas.remove(t);
        this.tiempo_ejecucioActual -= t.getTiempo_ejecucion();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public int getTiempo_ejecucioActual() {
        return tiempo_ejecucioActual;
    }
}
