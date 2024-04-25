package org.example.Recorridos;

import org.example.Grafo.Grafo;

import java.util.*;

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

    public ArrayList<T> BFS(){
        ArrayList<T> lista = new ArrayList<>();
        fila.clear();
        for (Integer i : this.vertices.keySet()) {
            if (this.vertices.get(i).equals(false)) {
                BFS_visit(i, lista);
            }
        }
        return lista;
    }

    private void BFS_visit(Integer vertice, ArrayList<T> lista){
        this.vertices.put(vertice, true); //marcado como visitado
        lista.add((T) vertice);
        fila.add(vertice); //agregar vertice a la fila
        while(!fila.isEmpty()){
            Integer v = fila.remove(); //me traigo el 1ro de la fila
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(v); //busco los adyacentes
            while(adyacentes.hasNext()){
                Integer ady = adyacentes.next(); // por c/ adyacente
                if(this.vertices.get(ady).equals(false)){ //
                    this.vertices.put(ady, true);
                    lista.add((T) ady);
                    this.fila.add(ady);
                }
            }
        }
    }

}
