package org.example.ej3_subconjunto;

import java.util.ArrayList;

public class backtracking_sumaSubconjunto {
    private int m;
    private int[] numeros;
    ArrayList<ArrayList<Integer>> subconjuntos;

    public backtracking_sumaSubconjunto(int m, int[] subconjunto) {
        this.m = m;
        this.numeros = subconjunto;
        this.subconjuntos = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> ej3() {
        ArrayList<Integer> sumas = new ArrayList<>();
        _backtracking_ej3(sumas, 0);
        return subconjuntos;
    }

    private void _backtracking_ej3(ArrayList<Integer> sumas, int sumaActual) {
        if(sumaActual == m && !sumas.contains(subconjuntos)){
            ArrayList<Integer> aux = new ArrayList<>(sumas);
            subconjuntos.add(aux);
        } else {
            for(int i = 0;i<numeros.length;i++){
                if(sumaActual+numeros[i] <= m && !sumas.contains(numeros[i])){//PODA

                    sumaActual+=numeros[i];
                    sumas.add(numeros[i]);

                    _backtracking_ej3(sumas, sumaActual);

                    sumas.removeLast();
                    sumaActual-=numeros[i];
                }
            }
        }

    }
}
