package org.example.ej4_dijkstra;

import org.example.Grafo.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class greedy_dijkstra {

    ArrayList<Integer> vertices;
    private GrafoDirigido<Integer> grafo;
    private Integer[] distancia;
    private Integer[] padres;

    public greedy_dijkstra(GrafoDirigido<Integer> grafo) {
        this.vertices = new ArrayList<>();
        this.grafo = grafo;
        this.distancia = new Integer[grafo.cantidadVertices()];
        this.padres = new Integer[grafo.cantidadVertices()];
    }

    public Integer[] getDistancia() {
        return distancia;
    }

    public Integer[] getPadres() {
        return padres;
    }

    public Integer[] greedy(int origen) {
        for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext(); ) {
            int i = it.next();
            distancia[i] = Integer.MAX_VALUE;
            padres[i] = Integer.MAX_VALUE;
        }

        padres[origen] = origen;
        distancia[origen] = 0;
        vertices.clear();
        for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext(); ) {
            int i = it.next();
            if(!vertices.contains(i)){
                Integer u = menor_valor();
                vertices.add(u);

                for(Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u); adyacentes.hasNext();){
                    Integer ady = adyacentes.next();

                    if(!vertices.contains(ady)){
                        if(distancia[u]+grafo.obtenerArco(u,ady).getEtiqueta()<distancia[ady]){
                            distancia[ady] = distancia[u]+grafo.obtenerArco(u,ady).getEtiqueta();
                            padres[ady] = u;
                        }
                    }
                }

            }
        }

        return padres;
    }

    private Integer menor_valor(){
        int r = Integer.MAX_VALUE;
        for(int i = 0; i< distancia.length; i++){
            if(distancia[i] < r){
                if(!vertices.contains(i)){
                    r = i;
                }
            }
        }
        return r;
    }
}
