package org.example.Recorridos;

import org.example.Grafo.Grafo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/** BreadthFirstSearch */
public class BFS<T> {
    private Grafo<Integer> grafo;
    private PriorityQueue<Integer> fila;
    private HashMap<Integer, Boolean> vertices;

    public BFS(Grafo<Integer> grafo) {
        this.grafo = grafo;
        this.fila = new PriorityQueue<>();
        this.cargarVertices();
    }

    private void cargarVertices() {
        this.vertices = new HashMap<>();
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()){
            this.vertices.put(it.next(), false);
        }
    }

    public void BFS(){
        fila.clear();
        for(Iterator<Integer> it = this.vertices.keySet().iterator(); it.hasNext();){
            Integer i = it.next();
            if(this.vertices.get(i).equals(false)){
                BFS_visit(i);
            }
        }
    }

    private void BFS_visit(Integer vertice){
        this.vertices.put(vertice, true); //marcado como visitado
        fila.add(vertice); //agregar vertice a la fila
        while(!fila.isEmpty()){
            Integer v = fila.remove(); //me traigo el 1ro de la fila
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(v); //busco los adyacentes
            while(adyacentes.hasNext()){
                Integer ady = adyacentes.next(); // por c/ adyacente
                if(this.vertices.get(ady).equals(false)){ //
                    this.vertices.put(ady, true);
                    this.fila.add(ady);
                }
            }
        }
    }

}
