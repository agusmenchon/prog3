package org.example.Recorridos;

import org.example.Grafo.Grafo;

import java.util.ArrayList;
import java.util.Iterator;


/**

 #### Ejercicio 5
 Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
 con todos los vértices a partir de los cuales exista un camino en G que termine en v.

 **/
public class ej5<T> {
    private Grafo<T> grafo;
    private T verticeDestino;
    private ArrayList<T> listaVertices;

    public ej5(Grafo<T> grafo, T verticeDestino) {
        this.grafo = grafo;
        this.verticeDestino = verticeDestino;
        this.listaVertices = new ArrayList<>();
    }

    public ArrayList<T> ej5(){
        Iterator<Integer> vertices = this.grafo.obtenerVertices();

        while(vertices.hasNext()){
            Integer v = vertices.next();
            if(!v.equals(verticeDestino)){

                if(ej5(v)){
                    this.listaVertices.add((T) v);
                }
            }
        }

        return this.listaVertices;
    }

    private Boolean ej5(Integer v) {
        if(v.equals(verticeDestino)){
            return true;
        }

        for(Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes((Integer) v); adyacentes.hasNext();) {
            Integer ady = adyacentes.next();
            if(ej5(ady)){
                return true;
            }
        }
        return false;
    }
}
