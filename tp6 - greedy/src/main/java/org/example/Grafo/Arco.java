package org.example.Grafo;

import java.util.Objects;

public class Arco<T> {

    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    @Override
    public boolean equals(Object o) {
        Arco<T> a2 = (Arco<T>) o;
        return verticeOrigen == a2.verticeOrigen && verticeDestino == a2.verticeDestino && Objects.equals(etiqueta, a2.etiqueta);
    }

    @Override
    public String toString() {
        return "Arco{" +
                "verticeOrigen=" + verticeOrigen +
                ", verticeDestino=" + verticeDestino +
                ", etiqueta=" + etiqueta +
                "}\n";
    }
}
