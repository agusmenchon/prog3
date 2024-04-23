package org.example.Grafo;

import java.util.LinkedList;

public class Vertice<T> {
    private int id;
    private LinkedList<Arco<T>> aristas;

    public Vertice(int id) {
        this.id = id;
        this.aristas = new LinkedList<>();
    }

    public void addArista(Vertice destino){

    }
}
