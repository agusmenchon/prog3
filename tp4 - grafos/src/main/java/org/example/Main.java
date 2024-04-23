package org.example;

import org.example.CSV.CSVReader;
import org.example.Grafo.Arco;
import org.example.Grafo.Grafo;
import org.example.Grafo.GrafoDirigido;
import org.example.Recorridos.BFS;
import org.example.Recorridos.DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 4);
        grafito.agregarArco(1, 3, null);
        grafito.agregarArco(2, 3, null);

        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
        Integer etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
        System.out.println("etiqueta: " + etiqueta); // Debería imprimir 4

//        Iterator<Arco<Integer>> t = grafito.obtenerArcos(1);
//        while(t.hasNext()){
//            System.out.print(t.next());
//        }

        System.out.println("---------- DFS ----------");
        String path2 = "tp4 - grafos/src/main/java/org/example/CSV/dataset2.txt";
        GrafoDirigido<Integer> g2 = new GrafoDirigido<>();
        CSVReader reader = new CSVReader(path2, g2);
        reader.read();

        DFS<Integer> dfs = new DFS<>(g2);
        ArrayList<Arco<Integer>> lista = dfs.dfs();
        for(Arco<Integer> l : lista){
            System.out.print(l);
        }

        System.out.println("---------- BFS ----------");
        BFS<Integer> bfs = new BFS<>(g2);
//        ArrayList<Arco<Integer>> lista2 = dfs.dfs();
//        for(Arco<Integer> l : lista2){
//            System.out.print(l);
//        }
    }
}