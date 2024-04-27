package org.example;

import org.example.CSV.CSVReader;
import org.example.Grafo.Arco;
import org.example.Grafo.Grafo;
import org.example.Grafo.GrafoDirigido;
import org.example.Recorridos.*;

import java.util.ArrayList;
import java.util.Iterator;

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

        String path2 = "tp4 - grafos/src/main/java/org/example/CSV/dataset1.txt";
        GrafoDirigido<Integer> g2 = new GrafoDirigido<>();
        CSVReader reader = new CSVReader(path2, g2);
        reader.read();
        System.out.println("---------- Grafo ----------");
        mostrarGrafo(g2);
//        g2.imprimir();

        System.out.print("---------- DFS ----------> ");
        DFS<Integer> dfs = new DFS<>(g2);
        ArrayList<Integer> lista = dfs.dfs();
        imprimirRecorrido(lista);

//        System.out.println("---------- EJ3----------");
        if(dfs.isCiclik()){
            System.out.print("Existe ciclo en el grafo");
        } else {
            System.out.print("No existe ciclo en el grafo");
        }

        System.out.print("\n---------- BFS ----------> ");
        BFS<Integer> bfs = new BFS<>(g2);
        ArrayList<Integer> lista2 = bfs.BFS();
        imprimirRecorrido(lista2);

        System.out.print("---------- EJ4 ----------> ");
        CaminoSimpleMayorLongitud<Integer> r = new CaminoSimpleMayorLongitud<>(g2, 1, 7);
        ArrayList<Integer> lista3 = r.recorridoMayorLongitud();
        imprimirRecorrido(lista3);
        System.out.print("la suma del camino simple de mayor longitud es: " + r.caminoMayorLongitud());

        System.out.print("\n---------- EJ5 ----------> ");
        ej5<Integer> ej5 = new ej5<>(g2, 7);
        ArrayList<Integer> lista4 = ej5.ej5();
        imprimirRecorrido(lista4);

        System.out.print("\n---------- EJ6 ----------> ");
        System.out.print("\n-- EJ6_dfs --> ");
        ej6<Integer> ej6 = new ej6<>(g2,1, 6);
        ArrayList<Integer> lista5 = ej6.ej6_DFS();
        imprimirRecorrido(lista5);

        System.out.print("\n-- EJ6_BFS --> ");
        ArrayList<Integer> lista6 = ej6.ej6_BFS();
        imprimirRecorrido(lista6);
    }

    public static void imprimirRecorrido(ArrayList<Integer> lista){
        for(Integer l : lista){
            if(!lista.getLast().equals(l)){
                System.out.print(l + "-");
            } else {
                System.out.print(l+"\n");
            }
        }
    }

    public static <T> void mostrarGrafo (Grafo<T> grafo)
    {
        // Recorremos todos los vertices
        Iterator<Integer> it = grafo.obtenerVertices();

        while (it.hasNext()) {
            Integer v = (Integer) it.next();
//            System.out.println("    " + v);
            // Recorremos todos los adyacentes de cada vertice
            Iterator<Arco<T>> itA = grafo.obtenerArcos(v);
            while (itA.hasNext()) {
                Arco<T> arco = itA.next();
                System.out.println("    " + v + "-> " + arco.getVerticeDestino() + " (" + arco.getEtiqueta() + ")");
            }
        }
    }
}