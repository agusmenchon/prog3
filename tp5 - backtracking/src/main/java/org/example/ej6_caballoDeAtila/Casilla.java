package org.example.ej6_caballoDeAtila;

import java.util.Objects;

public class Casilla {
    private boolean piso;
    private int valorX;
    private int valorY;
    private boolean visitada;

    public Casilla(boolean piso, int valorX, int valorY) {
        this.piso = piso;
        this.valorX = valorX;
        this.valorY = valorY;
        this.visitada = false;
    }

    public boolean visitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

    public boolean isPiso() {
        return piso;
    }

    public int getValorX() {
        return valorX;
    }

    public int getValorY() {
        return valorY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casilla casilla = (Casilla) o;
        return valorX == casilla.valorX && valorY == casilla.valorY;
    }


}
