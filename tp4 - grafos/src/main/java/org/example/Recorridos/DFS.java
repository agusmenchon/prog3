package org.example.Recorridos;

import org.example.Grafo.Arco;
import org.example.Grafo.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/** DepthFirstSearch */
public class DFS<T> {
    private Grafo<T> grafo;
    private HashMap<Integer, String> vertices;

    public DFS(Grafo<T> grafo) {
        this.grafo = grafo;
        this.vertices = new HashMap<>();
    }

    private void cargarVertices() {
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()){
            this.vertices.put(it.next(), "white");
        }
    }

    public ArrayList<Arco<T>> dfs(){
        this.cargarVertices();
        ArrayList<Arco<T>> lista = new ArrayList<>();

        for (Integer i : vertices.keySet()) {
            if (this.vertices.get(i).equals("white")) {
                dfs_visit(i, lista);
            }
        }
        return lista;
    }

    private void dfs_visit(Integer vertice, ArrayList<Arco<T>> lista){
        this.vertices.put(vertice, "yellow");
        for(Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();){
            Integer ady = adyacentes.next();
            if(this.vertices.get(ady).equals("white")){
                dfs_visit(ady, lista);
                Arco<T> arco = this.grafo.obtenerArco(vertice,ady);
                lista.add(arco);
            } else if (this.vertices.get(ady).equals("yellow")){
                System.out.println("existe un ciclo");
            }
        }
        this.vertices.put(vertice, "black");
    }
}
