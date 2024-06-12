package org.example.ej2_laberinto;

import java.util.ArrayList;

public class backtracking_laberinto {
    private Posicion[][] laberinto;
    private ArrayList<Posicion> mejorSolucion;
    private Posicion inicio;
    private Posicion fin;
    private int caminoMinimo;

    public backtracking_laberinto(Posicion[][] laberinto, Posicion inicio, Posicion fin) {
        this.laberinto = laberinto;
        this.mejorSolucion = new ArrayList<>();
        this.inicio = inicio;
        this.fin = fin;
        caminoMinimo = Integer.MAX_VALUE;
    }

    public int getCaminoMinimo() {
        return caminoMinimo;
    }

    public ArrayList<Posicion> backtracking_laberinto(){
        ArrayList<Posicion> solucionActual = new ArrayList<>();

        solucionActual.add(inicio);
        _backtracking_laberinto(solucionActual, inicio, inicio.getValor());

        return mejorSolucion;
    }

    private void _backtracking_laberinto(ArrayList<Posicion> solucionActual, Posicion pos, int sumaCaminoActual){
        if(sumaCaminoActual<caminoMinimo && pos.equals(fin)){
            mejorSolucion.clear();
            mejorSolucion.addAll(solucionActual);
            caminoMinimo = sumaCaminoActual;
        } else {
            ArrayList<Posicion> positions = getPosition(pos);
            for (Posicion p : positions) {
                if (sumaCaminoActual < caminoMinimo && !solucionActual.contains(p)) {
                    solucionActual.add(p);
                    sumaCaminoActual+=p.getValor();
                    _backtracking_laberinto(solucionActual, p, sumaCaminoActual);
                    solucionActual.remove(p);
                    sumaCaminoActual-=p.getValor();
                }
            }
        }
    }


    public ArrayList<Posicion> getPosition(Posicion pos) {
        ArrayList<Posicion> res = new ArrayList<>();
        if (pos.isArriba()) {
             res.add(laberinto[pos.getValorX()][pos.getValorY() -1]);
        }if (pos.isIzquierda()) {
            res.add(laberinto[pos.getValorX() - 1][pos.getValorY()]);
        }if (pos.isDerecha()) {
            res.add(laberinto[pos.getValorX() + 1][pos.getValorY()]);
        }if (pos.isAbajo()) {
            res.add(laberinto[pos.getValorX()][pos.getValorY()+ 1]);
        }
        return res;
    }


}
