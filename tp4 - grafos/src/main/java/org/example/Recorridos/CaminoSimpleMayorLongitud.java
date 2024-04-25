package org.example.Recorridos;

import org.example.Grafo.Grafo;

import java.util.ArrayList;
import java.util.Iterator;

public class CaminoSimpleMayorLongitud<T> {
    private Grafo<T> grafo;
    private T verticeOrigen;
    private T verticeDestino;
    private ArrayList<T> listaMayorLongitud;
    private int sumaMayorLongitud;

    public CaminoSimpleMayorLongitud(Grafo<T> grafo, T verticeOrigen, T verticeDestino) {
        this.grafo = grafo;
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.listaMayorLongitud = new ArrayList<>();
        this.sumaMayorLongitud =  0;
    }

    public ArrayList<T> recorridoMayorLongitud(){
        ArrayList<T> lista = new ArrayList<>();
        recorridoMayorLongitud(verticeOrigen, lista, 0);
        return listaMayorLongitud;
    }

    public int caminoMayorLongitud(){
        return this.sumaMayorLongitud;
    }

    private void recorridoMayorLongitud(T vertice, ArrayList<T> list, int caminoMayorLongitud) {
        if(caminoMayorLongitud > this.sumaMayorLongitud && vertice.equals(verticeDestino)){
            list.add(vertice);
            sumaMayorLongitud = caminoMayorLongitud;
            listaMayorLongitud.clear();
            listaMayorLongitud.addAll(list);
            return;
        }
        for(Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes((Integer) vertice); adyacentes.hasNext();){
            Integer ady = adyacentes.next();
            if(!list.contains(vertice)){
                list.add(vertice);
            }
            if(!list.contains(ady)){
                Integer etiqueta = (Integer) this.grafo.obtenerArco((Integer) vertice, ady).getEtiqueta();
                recorridoMayorLongitud((T) ady, list, caminoMayorLongitud+etiqueta);
                list.remove(ady);
            }
        }
        list.remove(vertice);
    }
}
