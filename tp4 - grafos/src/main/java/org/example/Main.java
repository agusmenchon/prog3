package org.example;

import org.example.CSV.CSVReader;
import org.example.Grafo.GrafoDirigido;
import org.example.Recorridos.BFS;
import org.example.Recorridos.DFS;
import org.example.Recorridos.CaminoSimpleMayorLongitud;

import java.util.ArrayList;

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
//        Integer etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
//        System.out.println("etiqueta: " + etiqueta); // Debería imprimir 4

//        Iterator<Arco<Integer>> t = grafito.obtenerArcos(1);
//        while(t.hasNext()){
//            System.out.print(t.next());
//        }

        String path2 = "tp4 - grafos/src/main/java/org/example/CSV/dataset1.txt";
        GrafoDirigido<Integer> g2 = new GrafoDirigido<>();
        CSVReader reader = new CSVReader(path2, g2);
        reader.read();
        g2.imprimir();

        System.out.println("---------- DFS ----------");
        DFS<Integer> dfs = new DFS<>(g2);
        ArrayList<Integer> lista = dfs.dfs();
        imprimirRecorrido(lista);

        System.out.println("---------- EJ3----------");
        if(dfs.isCiclik()){
            System.out.print("Existe ciclo en el grafo\n");
        } else {
            System.out.print("No existe ciclo en el grafo\n");
        }

        System.out.println("\n---------- BFS ----------");
        BFS<Integer> bfs = new BFS<>(g2);
        ArrayList<Integer> lista2 = bfs.BFS();
        imprimirRecorrido(lista2);

        System.out.println("\n---------- EJ4 ----------");
        CaminoSimpleMayorLongitud<Integer> r = new CaminoSimpleMayorLongitud<>(g2, 1, 7);
        ArrayList<Integer> lista3 = r.recorridoMayorLongitud();
        imprimirRecorrido(lista3);
        System.out.println("la suma del camino simple de mayor longitud es: " + r.caminoMayorLongitud());

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
}