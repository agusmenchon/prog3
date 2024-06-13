package org.example.ej2_mochila;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class greedy_mochila {
    PriorityQueue<Objeto> objetos;
    private Objeto[] solucion;
    private int capacidad;

    public greedy_mochila(PriorityQueue<Objeto> obj, int capacidad) {
        this.objetos = obj;
        this.solucion = new Objeto[objetos.size()];
        this.capacidad = capacidad;
    }

    public Objeto[] greedy(){
        double peso = 0;
        int i = 0;

        while(peso<capacidad){
            Objeto o = objetos.poll();

            if(peso+o.getPeso() < capacidad){
                solucion[i] = o;
                peso += o.getPeso();
            } else {
                double p = (capacidad-peso);
                o.setPeso(p);
                peso = capacidad;
                solucion[i] = o;
            }
            i++;
        }

        if(peso == capacidad){
            return solucion;
        }
        return null;
    }
}
