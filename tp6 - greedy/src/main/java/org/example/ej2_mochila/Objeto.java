package org.example.ej2_mochila;

public class Objeto implements Comparable{
    private String nombre;
    private double peso;
    private int valor;

    public Objeto(double peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public Objeto(String nombre, double peso, int valor) {
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Object o) {
        Objeto obj = (Objeto) o;
        if (this.getValor()/this.getPeso() < obj.getValor()/ obj.getPeso()){
            return 1;
        } else if (this.getValor()/this.getPeso() > obj.getValor()/ obj.getPeso()) {
            return -1;
        }
        return 0;
    }
}
