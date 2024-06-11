package org.example;

import org.example.Grafo.Grafo;
import org.example.Grafo.GrafoDirigido;
import org.example.ej1_salas.Backtracking_salas;
import org.example.ej2_laberinto.Posicion;
import org.example.ej2_laberinto.backtracking_laberinto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------- Ejercicio 1 -------------");
        ej1();

        System.out.println("--------- Ejercicio 2 -------------");
        ej2();

        System.out.println("--------- Ejercicio 3 -------------");
//        ej3();
//
//        System.out.println("--------- Ejercicio 4 -------------");
//        ej4();
//
//        System.out.println("--------- Ejercicio 5 -------------");
//        ej5();

//        System.out.println("--------- Ejercicio 6 -------------");
//        ej6();

    }

    public static void ej1(){
//        Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en
//        un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
//        permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
//        representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
//        puerta es un arco dirigido hacia otra habitación
        GrafoDirigido<Integer> g = new GrafoDirigido<>();

        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);

        g.agregarArco(1, 2, null);
        g.agregarArco(1, 4, null);
        g.agregarArco(2, 3, null);
        g.agregarArco(2, 6, null);
        g.agregarArco(3, 6, null);
        g.agregarArco(4, 2, null);
        g.agregarArco(4, 5, null);
        g.agregarArco(5, 2, null);
        g.agregarArco(5, 3, null);
        g.agregarArco(6, 5, null);

        Backtracking_salas b_s = new Backtracking_salas(g, 1,6);
        ArrayList<Integer> solucion = b_s.backtracking();

        b_s.imprimirSolucion(solucion);
        System.out.println("cant de recursiones: " + b_s.getCantSalasVisitadas());
    }

    public static void ej2(){
//        Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
//        cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
//        y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
//        camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
//        el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
//        booleanos, uno para cada dirección a la que se permite ir desde allí.

        int largo = 5;
        int ancho = 5;
        Posicion [][] laberinto = new Posicion[largo][ancho];
        //fila1
        Posicion p1 = new Posicion(0,0,55,false,false,false,true);
        Posicion p2 = new Posicion(1,0,10,false,true,true,false);
        Posicion p3 = new Posicion(2,0,15,false,false,false,false);
        Posicion p4 = new Posicion(3,0,34,false,false,false,false);
        Posicion p5 = new Posicion(4,0,29,false,false,false,false);
        laberinto[0][0] = p1;
        laberinto[1][0] = p2;
        laberinto[2][0] = p3;
        laberinto[3][0] = p4;
        laberinto[4][0] = p5;


        //fila2
        Posicion p6 = new Posicion(0,1,10,false,true,false,true);
        Posicion p7 = new Posicion(1,1,12,true,true,false,false);
        Posicion p8 = new Posicion(2,1,57,false,false,false,false);
        Posicion p9 = new Posicion(3,1,82,false,false,false,false);
        Posicion p10 = new Posicion(4,1,13,false,false,false,false);
        laberinto[0][1] = p6;
        laberinto[1][1] = p7;
        laberinto[2][1] = p8;
        laberinto[3][1] = p9;
        laberinto[4][1] = p10;

        //fila3
        Posicion p11 = new Posicion(0,2,42,true,true,false,true);
        Posicion p12 = new Posicion(1,2,10,true,false,true,true);
        Posicion p13 = new Posicion(2,2,56,false,false,true,true);
        /** Para probar otro camino, descomentar esta linea y comentar la de arriba. */
//        Posicion p13 = new Posicion(2,2,52136,false,false,true,true);
        Posicion p14 = new Posicion(3,2,17,false,true,true,false);
        Posicion p15 = new Posicion(4,2,24,false,true,false,false);
        laberinto[0][2] = p11;
        laberinto[1][2] = p12;
        laberinto[2][2] = p13;
        laberinto[3][2] = p14;
        laberinto[4][2] = p15;


        //fila4
        Posicion p16 = new Posicion(0,3,55,true,true,false,false);
        Posicion p17 = new Posicion(1,3,10,false,true,false,false);
        Posicion p18 = new Posicion(2,3,15,false,false,false,false);
        Posicion p19 = new Posicion(3,3,71,true,true,false,true);
        Posicion p20 = new Posicion(4,3,26,true,false,true,false);
        laberinto[0][3] = p16;
        laberinto[1][3] = p17;
        laberinto[2][3] = p18;
        laberinto[3][3] = p19;
        laberinto[4][3] = p20;

        //fila5
        Posicion p21 = new Posicion(0,4,48,true,false,false,true);
        Posicion p22 = new Posicion(1,4,10,true,false,true,true);
        Posicion p23 = new Posicion(2,4,15,false,false,true,true);
        Posicion p24 = new Posicion(3,4,11,true,false,true,false);
        Posicion p25 = new Posicion(4,4,28,false,false,false,false);
        laberinto[0][4] = p21;
        laberinto[1][4] = p22;
        laberinto[2][4] = p23;
        laberinto[3][4] = p24;
        laberinto[4][4] = p25;

        for(int j=0;j<largo;j++){
            for(int i = 0;i<ancho;i++){
                System.out.print(laberinto[i][j].getValor() + "| ");
            }
            System.out.print("\n");
        }

        backtracking_laberinto ej2 = new backtracking_laberinto(laberinto,p1,p14);
        ArrayList<Posicion> l = ej2.backtracking_laberinto();
        for(Posicion p : l){
            System.out.print(p.getValor() + "=> ");
        }
        System.out.println("Suma camino minimo: " + ej2.getCaminoMinimo());
    }


}