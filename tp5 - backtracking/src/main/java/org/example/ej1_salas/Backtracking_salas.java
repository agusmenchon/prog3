package org.example.ej1_salas;

import org.example.Grafo.Grafo;
import org.example.Grafo.Vertice;

import java.util.ArrayList;
import java.util.Iterator;

public class Backtracking_salas {
    private Grafo g;
    private Integer entrada;
    private Integer salida;
    ArrayList<Integer> solucion;
    private int cantSalasVisitadas;

    public Backtracking_salas(Grafo g, Integer entrada, Integer salida) {
        this.g = g;
        this.entrada = entrada;
        this.salida = salida;
        this.solucion = new ArrayList<>();
        this.cantSalasVisitadas = 0;
    }

    public int getCantSalasVisitadas() {
        return cantSalasVisitadas;
    }

    public ArrayList<Integer> backtracking(){
        ArrayList<Integer> solucionActual = new ArrayList<>();
        solucionActual.add(entrada);
        _backtracking(solucionActual, entrada);

        return solucion;
    }

    private void _backtracking(ArrayList<Integer> solucionActual, Integer verticeActual){
        cantSalasVisitadas++;
        if(solucionActual.size() > solucion.size() && verticeActual==salida){
            System.out.println();
            solucion.clear();
            solucion.addAll(solucionActual);
        } else {
            for (Iterator it = g.obtenerAdyacentes(verticeActual); it.hasNext(); ) {
                Integer v = (Integer) it.next();

                //poda = si en la solucion ya existe el V.
                if(!solucionActual.contains(v)){
                    solucionActual.add(v);
                    _backtracking(solucionActual, v);
                }

                solucionActual.remove(v);
            }
        }
    }

    public void imprimirSolucion(ArrayList<Integer> sol){
        for(Integer i : sol){
            System.out.print(i + " => ");
        }
        System.out.println("\ncant salas: " + sol.size());
        System.out.println("");
    }
}
