package org.example.Recorridos;

import org.example.Grafo.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
 * es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
 * esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
 * cantidad de cuadras posible. */
public class ej6<T> {
    private Grafo<T> grafo;
    private T verticeOrigen;
    private T verticeDestino;
    private Integer cantMayorCaminos;

    public ej6(Grafo<T> grafo, T verticeOrigen, T verticeDestino) {
        this.grafo = grafo;
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.cantMayorCaminos = Integer.MAX_VALUE;
    }

    /** ------------- CON DFS --------------- */
    public ArrayList<T> ej6_DFS(){
        ArrayList<T> lista = new ArrayList<>();
        ArrayList<T> listaAux = new ArrayList<>();

        listaAux.add(verticeOrigen);
        ej6_DFS(verticeOrigen,listaAux,lista);
        return lista;
    }

    private void ej6_DFS(T vertice, ArrayList<T> listAux, ArrayList<T> listaCamino) {
        if(listAux.size() < this.cantMayorCaminos && vertice.equals(verticeDestino)){
            listaCamino.clear();
            this.cantMayorCaminos = listAux.size();
            listaCamino.addAll(listAux);
            return;
        }

        for(Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes((Integer) vertice); adyacentes.hasNext();) {
            Integer ady = adyacentes.next();
            if(!listAux.contains(ady)){
                listAux.add((T) ady);
                ej6_DFS((T) ady, listAux,listaCamino);
                listAux.remove(ady);
            }
        }
    }

    /** ------------- CON BFS --------------- */
    public ArrayList<T> ej6_BFS(){
        HashMap<Integer, Boolean> vertices = new HashMap<>();
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()){
            vertices.put(it.next(), false);
        }
        int padres[] = new int [grafo.cantidadVertices()+1];
        int niveles[] = new int [grafo.cantidadVertices()+1];
        PriorityQueue<Integer> fila = new PriorityQueue<>();

        return (ArrayList<T>) ej6_BFS((Integer) verticeOrigen, padres,niveles, fila, vertices);
    }

    private ArrayList<Integer> ej6_BFS(Integer vertice,
                         int [] padres,
                         int [] niveles,
                         PriorityQueue<Integer> fila,
                         HashMap<Integer, Boolean> vertices){
        ArrayList<Integer> lista = new ArrayList<>();

        vertices.put(vertice, true); //marcado como visitado

        fila.add(vertice); //agregar vertice a la fila
//
        while(!fila.isEmpty()){
            Integer v = fila.remove(); //me traigo el 1ro de la fila
            Iterator<Integer> hijos = this.grafo.obtenerAdyacentes(v); //busco los adyacentes

            while(hijos.hasNext()){
                Integer hijo = hijos.next(); // por cada adyacente

                if(vertices.get(hijo).equals(false)){ //si el hijo no esta visitado

                    /** guardo quien es el padre de hijo en -> array[hijo] = Valor del padre */
                    /** y el nivel en el que se encuentra ese hijo */
                    padres[hijo] = v;
                    niveles[hijo] = niveles[padres[hijo]]+1;

                    // marco el vertice como visitado
                    vertices.put(hijo, true);

                    // se agrega a la cola
                    fila.add(hijo);

                    /** Si el hijo coincide con el vertice buscado,
                     *  itero el array de padres moviendo el indice i sobre el padre del padre
                     *  para ir agregando a la lista y asi mostrarlo por pantalla */
                    if(hijo.equals(verticeDestino)){
                        lista.addFirst(hijo);
                        int i = padres[hijo];
                        while(i!=padres[vertice]){
                            lista.addFirst(i);
                            i = padres[i];
                        }

                        return lista;
                    }
                }
            }

        }
        return lista;
    }
}


