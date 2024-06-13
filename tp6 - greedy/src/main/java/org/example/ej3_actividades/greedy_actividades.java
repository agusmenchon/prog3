package org.example.ej3_actividades;

import java.util.ArrayList;

public class greedy_actividades {


    public greedy_actividades() {
//        this.solucion = new ArrayList<>();
    }

    public ArrayList<Actividad> greedy(Actividad[] actividades, double hora_inicio){
        ArrayList<Actividad> solucion = new ArrayList<>();
        int i = 0;
        while(i<actividades.length || solucion.isEmpty()){
            Actividad a = seleccionar(actividades, hora_inicio);
            if(a!=null){
                if(factible(a, solucion)){
                    solucion.add(a);
                    hora_inicio = a.getTiempo_fin();
                }
            }
            i++;
        }

        return solucion;
    }

    private boolean factible(Actividad aColocar, ArrayList<Actividad> solucion){
        if(solucion.isEmpty()){
            return true;
        } else if (aColocar.getTiempo_inicio() > solucion.getLast().getTiempo_fin()){
            return true;
        }
        return false;
    }

    public Actividad seleccionar(Actividad[] actividades, double hora_inicio){
        Actividad n = null;
        int j = 0;
        double termina_antes = Double.MAX_VALUE;

        for(int i = 0;i<actividades.length;i++){
            if(actividades[i]!=null){
                if(actividades[i].getTiempo_inicio()>=hora_inicio){

                    double tiempo = actividades[i].getTiempo_fin();

                    if(tiempo<termina_antes){
                        termina_antes = tiempo;
                        j = i;
                        n = actividades[i];
                    }
                }
            }
        }

        if(n!=null){
            actividades[j] = null;
            return n;
        }
        return n;
    }
}
