package org.example.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T>{

    private int cantVertices;
    private int cantArcos;
    private HashMap<Integer, LinkedList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.cantArcos = 0;
        this.cantVertices = 0;
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if(!this.vertices.containsKey(verticeId)){
            this.vertices.put(verticeId, new LinkedList<>());
            cantVertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if(this.contieneVertice(verticeId)){
            Iterator<Integer> vertices = this.obtenerVertices();

            while(vertices.hasNext()) {
                Integer vertice = vertices.next();
                Arco<T> arco = this.obtenerArco(vertice, verticeId);
                if (arco != null) {
                    this.borrarArco(vertice, arco);
                }
            }

            this.vertices.remove(verticeId);
            cantVertices--;
        }
    }
    private void borrarArco(Integer vertice, Arco<T> a1) {
        this.vertices.get(vertice).remove(a1);
    }

    @Override
    public void agregarArco(int origen, int destino, T etiqueta) {
        if(this.vertices.containsKey(origen) && this.vertices.containsKey(destino)){
           Arco<T> arco = new Arco<>(origen, destino, etiqueta);
           this.vertices.get(origen).addFirst(arco);
           cantArcos++;
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if(this.vertices.containsKey(verticeId1) && this.vertices.containsKey(verticeId2)){
            Arco<T> t = this.obtenerArco(verticeId1, verticeId2);
            this.vertices.get(verticeId1).remove(t);
            cantArcos--;
        }
    }


    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Arco<T> t = this.obtenerArco(verticeId1,verticeId2);
        return t != null;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(this.vertices.containsKey(verticeId1) && this.vertices.containsKey(verticeId2)){
            Iterator<Arco<T>> arcos = this.vertices.get(verticeId1).iterator();
            while(arcos.hasNext()){
                Arco<T> arco = arcos.next();
                if(arco.getVerticeOrigen()==verticeId1 && arco.getVerticeDestino()==verticeId2){
                    return arco;
                }
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return this.cantVertices;
    }

    @Override
    public int cantidadArcos() {
        return this.cantArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return this.vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> adyacentes = new ArrayList<>();

        Iterator<Arco<T>> arco = this.obtenerArcos(verticeId); arco.next();
        while(arco.hasNext()){
            Arco<T> a = arco.next();
            adyacentes.add(a.getVerticeDestino());
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        for(Iterator<Integer> t = this.obtenerVertices(); t.hasNext();){
            Integer vertice = t.next();
            arcos.addAll(vertices.get(vertice));
//            Iterator<Arco<T>> a = this.obtenerArcos(t.next()); a.hasNext();
//            while(a.hasNext()){
//                Arco<T> arco = a.next();
//                arcos.add(arco);
//            }
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if(this.vertices.containsKey(verticeId)) {
            return this.vertices.get(verticeId).iterator();
        }
        return null;
    }
}
