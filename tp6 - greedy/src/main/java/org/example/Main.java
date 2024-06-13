package org.example;


import org.example.Grafo.GrafoDirigido;
import org.example.ej1_monedas.greedy_monedas;
import org.example.ej2_mochila.Objeto;
import org.example.ej2_mochila.greedy_mochila;
import org.example.ej3_actividades.Actividad;
import org.example.ej3_actividades.greedy_actividades;
import org.example.ej4_dijkstra.greedy_dijkstra;
import org.example.ej7_cd.Cancion;
import org.example.ej7_cd.greedy_cd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------- Ejercicio 1 -------------");
        ej1();

        System.out.println("--------- Ejercicio 2 -------------");
        ej2();

        System.out.println("--------- Ejercicio 3 -------------");
        ej3();

        System.out.println("--------- Ejercicio 4 -------------");
        ej4();
//
//        System.out.println("--------- Ejercicio 5 -------------");
//        ej5();
//
//        System.out.println("--------- Ejercicio 6 -------------");
//        ej6();
//
        System.out.println("\n--------- Ejercicio 7 -------------");
        ej7();
    }

    public static void ej1(){
//        Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
//        ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
//        número de ellas.
//        Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
//        si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de 10$ y 4 de 1$.

        int [] monedas = new int[5];
        monedas[0] = 100;
        monedas[1] = 25;
        monedas[2] = 10;
        monedas[3] = 5;
        monedas[4] = 1;

        int pago = 369;

        greedy_monedas g = new greedy_monedas();
        ArrayList<Integer> solucion = g.greedy(monedas, pago);

        g.imprimirResultado(solucion);
    }

    public static void ej2(){
//        Problema de la mochila: Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un peso
//        positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El objetivo es
//        llenar la mochila de tal manera que se maximice el valor de los objetos transportados, respetando la
//        limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una fracción xi (0 ≤ xi ≤ 1)
//        del objeto i es ubicada en la mochila contribuye en xipi al peso total de la mochila y en xivi al valor
//        de la carga.
//        ¿Qué estrategia Greedy seguiría para resolver el problema? Esquematice la resolución mediante un
//        pseudocódigo en Java.

        Objeto pan = new Objeto("pan", 1,1500);
        Objeto chocolate = new Objeto("chocolate", 1,5600);
        Objeto plata = new Objeto("plata", 0.5,500000);
        Objeto platino = new Objeto("platino", 0.3,200000);

        PriorityQueue<Objeto> cola = new PriorityQueue<>();
        cola.add(pan);
        cola.add(chocolate);
        cola.add(plata);
        cola.add(platino);

        greedy_mochila greedy = new greedy_mochila(cola, 2);
        Objeto[] res = greedy.greedy();

        double suma = 0;
        double peso = 0;
        for(int i = 0;i<res.length;i++){
            suma+=res[i].getValor()*res[i].getPeso();
            peso+=res[i].getPeso();
            System.out.println(res[i].getNombre() + " - " + res[i].getValor() + " - " + res[i].getPeso());
        }

        System.out.println("total valor mochila: " + suma);
        System.out.println("total peso mochila: " + peso);

    }

    public static void ej3(){
//        Maximizar el número de actividades compatibles. Se tienen n actividades que necesitan utilizar un
//        recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado un
//        tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi. Si la
//        actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
//        compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
//        consiste en encontrar la cantidad máxima de actividades compatibles entre sí
        Actividad ac1 = new Actividad("1",12.00,15.30);
        Actividad ac2 = new Actividad("2",16.00,17.00);
        Actividad ac3 = new Actividad("3",12.30,18.30);
        Actividad ac4 = new Actividad("4",14.00,20.30);
        Actividad ac5 = new Actividad("5",17.30,21.00);
        Actividad ac6 = new Actividad("6",17.00,22.00);

        Actividad[] actividades = new Actividad[6];

        actividades[0] = ac1;
        actividades[1] = ac2;
        actividades[2] = ac3;
        actividades[3] = ac4;
        actividades[4] = ac5;
        actividades[5] = ac6;

        greedy_actividades g = new greedy_actividades();
        ArrayList<Actividad> solucion = g.greedy(actividades, 12.00);

        for(Actividad a : solucion){
            System.out.println("Nombre: " + a.getNombre() + " - " + "Inicio: " + a.getTiempo_inicio() + " - " + " Fin: " + a.getTiempo_fin());
        }
    }
    public static void ej4(){
//        Algoritmo de Dijkstra. Dado un grafo con pesos no negativos, implemente el algoritmo de Dijkstra
//        para determinar el array de distancias y de predecesores en el camino más corto, desde un vértice
//        orígen dado como parámetro hacia el resto de los vértices. Una vez realizado, imprima el camino
//        más corto que se debe seguir desde el orígen hacia cada vértice.
        GrafoDirigido<Integer> g = new GrafoDirigido<>();
        g.agregarVertice(0);
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);

        g.agregarArco(0,1,15);
        g.agregarArco(0,2,5);
        g.agregarArco(0,3,10);
        g.agregarArco(1,4,7);
        g.agregarArco(2,4,25);
        g.agregarArco(3,6,4);
        g.agregarArco(4,5,10);
        g.agregarArco(5,6,18);

        greedy_dijkstra greedy = new greedy_dijkstra(g);
        Integer[] padres = greedy.greedy(0);
        Integer[] distancia = greedy.getDistancia();
        System.out.print("Padres:     ");
        for(int i = 0;i<padres.length;i++){
            System.out.print(padres[i] + " | ");
        }
        System.out.print("\nDistancias: ");
        for(int i = 0;i<distancia.length;i++){
            System.out.print(distancia[i] + " | ");
        }

    }
    public static void ej5(){
//        Desde un cierto conjunto grande de ciudades del interior de una provincia, se desean transportar
//        cereales hasta alguno de los 3 puertos pertenecientes al litoral de la provincia. Se pretende
//        efectuar el transporte total con mínimo costo sabiendo que el flete es más caro cuanto más
//        distancia tiene que recorrer. Dé un algoritmo que resuelva este problema, devolviendo para cada
//        ciudad el camino que debería recorrer hacia el puerto de menor costo
    }
    public static void ej6(){
//        Problema del viajante. Dado un grafo ponderado de ciudades conectadas todas con todas,
//        implemente un algoritmo que brinde una aproximación al problema del viajante.

    }
    public static void ej7(){
//        Armando CDs. Dado un conjunto de archivos de canciones, donde cada uno tiene la información de
//        nombre, género, duración del tema, y tamaño en kilobytes, se desea grabar un disco CD (que tiene
//        una capacidad máxima de M kilobytes) de modo tal de:
//          ● Variante A: Maximizar la capacidad ocupada del disco CD.
//          ● Variante B: Maximizar la cantidad de canciones que se pueden grabar en el CD.
//        Para ambas variantes se quiere, además, que el CD no contenga más de 3 canciones de un mismo
//        género.

        Cancion c1 = new Cancion("c1", "Rock", 125, 1500);
        Cancion c2 = new Cancion("c2", "Reggaeton", 260, 3200);
        Cancion c3 = new Cancion("c3", "Pop", 110, 1300);
        Cancion c4 = new Cancion("c4", "Pop", 353, 3800);
        Cancion c5 = new Cancion("c5", "Reggae", 100, 1400);
        Cancion c6 = new Cancion("c6", "Folklore", 75, 900);
        Cancion c7 = new Cancion("c7", "Reggaeton", 286, 2550);
        Cancion c8 = new Cancion("c8", "Pop", 420, 3000);

        Cancion[] canciones = new Cancion[8];
        canciones[0] = c1;
        canciones[1] = c2;
        canciones[2] = c3;
        canciones[3] = c4;
        canciones[4] = c5;
        canciones[5] = c6;
        canciones[6] = c7;
        canciones[7] = c8;

        greedy_cd A = new greedy_cd(11400, canciones);
        greedy_cd B = new greedy_cd(11400, canciones);

        ArrayList<Cancion> a = A.greedy("A");
        System.out.println("\n--- Variante A --- Maximizar la capacidad ocupada del disco CD.");
        A.imprimirSolucion(a);

        ArrayList<Cancion> b = B.greedy("B");
        System.out.println("\n--- Variante B --- Maximizar la cantidad de canciones que se pueden grabar en el CD.");
        B.imprimirSolucion(b);

    }
}