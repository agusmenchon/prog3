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
    private Boolean ciclico;

    public DFS(Grafo<T> grafo) {
        this.grafo = grafo;
        this.vertices = new HashMap<>();
        this.ciclico = false;
    }

    private void cargarVertices() {
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()){
            this.vertices.put(it.next(), "white");
        }
    }

    public ArrayList<T> dfs(){
        this.cargarVertices();
        ArrayList<T> lista = new ArrayList<>();

        for (Integer i : vertices.keySet()) {
            if (this.vertices.get(i).equals("white")) {
                dfs_visit(i, lista);
            }
        }
        return lista;
    }

    public Boolean isCiclik(){
        return this.ciclico;
    }

    private void dfs_visit(Integer vertice, ArrayList<T> lista){
        this.vertices.put(vertice, "yellow");
        if(!lista.contains(vertice)){
            lista.add((T) vertice);
        }
        for(Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();){
            Integer ady = adyacentes.next();
            if(this.vertices.get(ady).equals("white")){
                lista.add((T) ady);
                dfs_visit(ady, lista);
//                Arco<T> arco = this.grafo.obtenerArco(vertice,ady);
            } else if (this.vertices.get(ady).equals("yellow")){
                this.ciclico = true;
            }
        }
        this.vertices.put(vertice, "black");
    }
}
