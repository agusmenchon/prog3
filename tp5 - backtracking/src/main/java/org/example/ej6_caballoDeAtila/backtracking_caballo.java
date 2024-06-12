package org.example.ej6_caballoDeAtila;

import java.util.ArrayList;

public class backtracking_caballo {
    private Casilla[][] jardin;
    private ArrayList<Casilla> camino;
    private Casilla inicio;

    public backtracking_caballo(Casilla[][] jardin, Casilla inicio) {
        this.jardin = jardin;
        this.camino = new ArrayList<>();
        this.inicio = inicio;
    }

    public ArrayList<Casilla> bactracking(){
        ArrayList<Casilla> caminoActual = new ArrayList<>();
        _backtracking(caminoActual, inicio);

        return camino;
    }

    private void _backtracking(ArrayList<Casilla> caminoActual, Casilla pos){
        if(pos.equals(inicio) && !caminoActual.isEmpty() /* && pos.visitada() */){
            if(camino.size() < caminoActual.size()){
                camino.clear();
                camino.addAll(caminoActual);
                camino.add(pos);
            }
        } else {
            ArrayList<Casilla> vecinos = this.casillasVecinas(pos.getValorX(), pos.getValorY());
            for(Casilla c : vecinos){
                if(!c.visitada()){

                    caminoActual.add(pos);
                    if(!pos.equals(inicio)){
                        pos.setVisitada(true);
                    }

                    _backtracking(caminoActual, c);

                    caminoActual.removeLast();
                    pos.setVisitada(false);
                }
            }
        }
    }

    private ArrayList<Casilla> casillasVecinas(int x, int y){
        ArrayList<Casilla> vecinos = new ArrayList<>();
        //arriba
        if(y-1>=0 && jardin[x][y-1].isPiso()){
            vecinos.add(jardin[x][y-1]);
        }
        //abajo
        if(y+1<jardin.length && jardin[x][y+1].isPiso()){
            vecinos.add(jardin[x][y+1]);
        }
        //izquierda
        if(x-1>=0 && jardin[x-1][y].isPiso()){
            vecinos.add(jardin[x-1][y]);
        }
        //derecha
        if(x+1<jardin.length && jardin[x+1][y].isPiso()){
            vecinos.add(jardin[x+1][y]);
        }
        return vecinos;
    }
}
