package org.example.ej5_procesadores;

import java.util.ArrayList;
import java.util.List;

public class Solucion {

    private ArrayList<Procesador> procesadores;
    private int procesadorMayorTiempo;

    public Solucion(Procesador [] procesadores) {
        this.procesadores = new ArrayList<>(List.of(procesadores));
    }

    public Solucion() {
        this.procesadores = new ArrayList<>();
    }

    public ArrayList<Procesador> getProcesadores() {
        return procesadores;
    }

    public void setProcesadores(ArrayList<Procesador> procesadores) {
        this.procesadores.clear();
        this.procesadores = procesadores;
    }

    public void addSolucion(ArrayList<Procesador> s){
        this.procesadores.clear();
        this.procesadores.addAll(s);
    }

    public void addTarea(Procesador p, Tarea t){
        p.addTarea(t);
//        int i = procesadores.indexOf(p);
//        procesadores.get(i).addTarea(t);
//        if(procesadores.get(i).getTiempo_ejecucioActual() > procesadorMayorTiempo.getTiempo_ejecucioActual()){
//            procesadorMayorTiempo = p;
//        }
    }

    public void deleteTarea(Procesador p, Tarea t){
        p.deleteTarea(t);
    }

    public int procMayorTiempo(){
        int i = 0;
        for(Procesador p : procesadores){
            if(p.getTiempo_ejecucioActual() > i){
                i = p.getTiempo_ejecucioActual();
            }
        }
        return i;

//        Procesador proc = procesadores.getFirst();
//        for(Procesador p : procesadores){
//            if(p.getTiempo_ejecucioActual() > proc.getTiempo_ejecucioActual()){
//                proc = p;
//            }
//        }
//
//        return proc;
    }
}
