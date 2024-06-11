package org.example.ej2_laberinto;

public class Posicion {

    private int valorX;
    private int valorY;
    private int valor;

    private boolean arriba;
    private boolean abajo;
    private boolean izquierda;
    private boolean derecha;

    public Posicion(int valorX, int valorY, int valor, boolean arriba, boolean abajo, boolean izquierda, boolean derecha) {
        this.valorX = valorX;
        this.valorY = valorY;
        this.valor = valor;
        this.arriba = arriba;
        this.abajo = abajo;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Posicion(int valor, boolean arriba, boolean abajo, boolean izquierda, boolean derecha) {
        this.valor = valor;
        this.arriba = arriba;
        this.abajo = abajo;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public int getValorX() {
        return valorX;
    }

    public int getValorY() {
        return valorY;
    }

    public int getValor() {
        return valor;
    }

    public boolean isArriba() {
        return arriba;
    }

    public boolean isAbajo() {
        return abajo;
    }


    public boolean isIzquierda() {
        return izquierda;
    }

    public boolean isDerecha() {
        return derecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return valorX == posicion.valorX && valorY == posicion.valorY && valor == posicion.valor;
    }
}
