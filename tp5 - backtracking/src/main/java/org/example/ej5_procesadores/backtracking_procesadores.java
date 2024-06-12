package org.example.ej5_procesadores;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class backtracking_procesadores {
    private Procesador[] procesadores;
    private PriorityQueue<Tarea> tareas;
    private Solucion mejorSolucion;
//    private Procesador mayorTiempoEjec;

    public backtracking_procesadores(Procesador[] procesadores, PriorityQueue<Tarea> tareas) {
        this.procesadores = procesadores;
        this.tareas = tareas;
        this.mejorSolucion = new Solucion();
//        this.mayorTiempoEjec = null;
    }

    public ArrayList<Procesador> backtracking(){
//        ArrayList<Procesador> solucionActual = new ArrayList<>(List.of(procesadores));
        Solucion s = new Solucion(procesadores);

        _backtracking_procesadores(s);

        return mejorSolucion.getProcesadores();
    }

    private void _backtracking_procesadores(Solucion s) {
        if(tareas.isEmpty()){
            if(mejorSolucion.getProcesadores().isEmpty()){
                mejorSolucion.setProcesadores(s.getProcesadores());
            } else {
                if(s.procMayorTiempo() < mejorSolucion.procMayorTiempo()){
                    this.cambiarMejorSolucion(s);
                }
            }
        } else {
            while(!tareas.isEmpty()){ //mientras haya tareas por agregar...
                Tarea t = tareas.remove(); //agarro la primer tarea de la cola

                for(Procesador p : s.getProcesadores()){ //itero todos los procesadores
//                    if(p.getTiempo_ejecucioActual() < s.)
                    s.addTarea(p, t);

                    _backtracking_procesadores(s);

                    s.deleteTarea(p, t);
                    tareas.add(t);
                }

            }
        }
    }

    private void cambiarMejorSolucion(Solucion solucionActual){
        mejorSolucion.addSolucion(solucionActual.getProcesadores());
    }


}
