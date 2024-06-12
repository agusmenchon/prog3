package org.example;

import org.example.Grafo.GrafoDirigido;
import org.example.ej1_salas.Backtracking_salas;
import org.example.ej2_laberinto.Posicion;
import org.example.ej2_laberinto.backtracking_laberinto;
import org.example.ej3_subconjunto.backtracking_sumaSubconjunto;
import org.example.ej5_procesadores.Procesador;
import org.example.ej5_procesadores.Tarea;
import org.example.ej5_procesadores.backtracking_procesadores;
import org.example.ej6_caballoDeAtila.Casilla;
import org.example.ej6_caballoDeAtila.backtracking_caballo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.print("--------- Ejercicio 1 -------------\n");
        ej1();

        System.out.println("--------- Ejercicio 2 -------------");
        ej2();

        System.out.println("--------- Ejercicio 3 -------------");
        ej3();

//        System.out.println("--------- Ejercicio 4 -------------");
//        ej4();

//        System.out.println("--------- Ejercicio 5 -------------");
//        ej5();

        System.out.println("--------- Ejercicio 6 -------------");
        ej6();

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

        g.imprimir();

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

    public static void ej3(){
//        Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
//        combinaciones de esos números tal que la suma sea igual a M.
        /** Subjconjunto del 1 al 10 y M = 10 */
        int m = 10;
        int [] subconjunto = new int[m];

        for(int j = 0;j<m;j++){
            subconjunto[j] = j+1;
        }

        backtracking_sumaSubconjunto backtracking_sumaSubconjunto = new backtracking_sumaSubconjunto(m, subconjunto);
        ArrayList<ArrayList<Integer>> res = backtracking_sumaSubconjunto.ej3();

        for(ArrayList<Integer> p : res){
            int suma = 0;
            for(int i = 0; i<p.size();i++){
                if(i<p.size()-1){
                    System.out.print(p.get(i)+"+");
                } else {
                   System.out.print(p.get(i));
                }
                suma+=p.get(i);
            }
            System.out.print(" = " + suma+"\n");
        }
    }

    public static void ej4(){
//      Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en
//      dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma
        int m = 10;
        int [] conjunto = new int[m];

        for(int j = 0;j<m;j++){
            conjunto[j] = j+1;
        }
    }

    public static void ej5(){
//    Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo
//    de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
//    minimizar el tiempo de ejecución del total de tareas.
        Procesador[] procesadores = new Procesador[3];

        Procesador p1 = new Procesador("p1");
        Procesador p2 = new Procesador("p2");
        Procesador p3 = new Procesador("p3");

        procesadores[0] = p1;
        procesadores[1] = p2;
        procesadores[2] = p3;

        PriorityQueue<Tarea> colaTareas = new PriorityQueue<>();

        Tarea t1 = new Tarea("t1", 50);
        Tarea t2 = new Tarea("t2", 75);
        Tarea t3 = new Tarea("t3", 25);
        Tarea t4 = new Tarea("t4", 10);
        Tarea t5 = new Tarea("t5", 101);
        Tarea t6 = new Tarea("t6", 48);
        Tarea t7 = new Tarea("t7", 87);
        Tarea t8 = new Tarea("t8", 15);

        colaTareas.add(t1);
        colaTareas.add(t2);
        colaTareas.add(t3);
        colaTareas.add(t4);
        colaTareas.add(t5);
        colaTareas.add(t6);
        colaTareas.add(t7);
        colaTareas.add(t8);

//        Tarea[] tareas = new Tarea[8];

//        tareas[0] = t1;
//        tareas[1] = t2;
//        tareas[2] = t3;
//        tareas[3] = t4;
//        tareas[4] = t5;
//        tareas[5] = t6;
//        tareas[6] = t7;
//        tareas[7] = t8;


        backtracking_procesadores back = new backtracking_procesadores(procesadores, colaTareas);
        ArrayList<Procesador> mejorSolucion = back.backtracking();
        for(Procesador p : mejorSolucion){
            System.out.println(p.getNombre() + " - tareas: " + p.getTareas());
        }
    }

    public static void ej6(){
//    Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
//    directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió a
//    ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
//    casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
//    caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas todavía
//    había pasto (señal de que en ellas no había estado el caballo). Escriba un algoritmo que deduzca el
//    recorrido completo que hizo el caballo.
        int alto = 5;
        int ancho = 5;
        Casilla[][] jardin = new Casilla[ancho][alto];

        Casilla c1 = new Casilla(false, 0,0);
        Casilla c2 = new Casilla(false, 1,0);
        Casilla c3 = new Casilla(false, 2,0);
        Casilla c4 = new Casilla(false, 3,0);
        Casilla c5 = new Casilla(false, 4,0);

        Casilla c6 = new Casilla(true, 0,1);
        Casilla c7 = new Casilla(true, 1,1);
        Casilla c8 = new Casilla(false, 2,1);
        Casilla c9 = new Casilla(false, 3,1);
        Casilla c10 = new Casilla(false, 4,1);

        Casilla c11 = new Casilla(true, 0,2);
        Casilla c12 = new Casilla(true, 1,2);
        Casilla c13 = new Casilla(true, 2,2);
        Casilla c14 = new Casilla(false, 3,2);
        Casilla c15 = new Casilla(false, 4,2);

        Casilla c16 = new Casilla(true, 0,3);
        Casilla c17 = new Casilla(true, 1,3);
        Casilla c18 = new Casilla(true, 2,3);
        Casilla c19 = new Casilla(false, 3,3);
        Casilla c20 = new Casilla(false, 4,3);

        Casilla c21 = new Casilla(false, 0,4);
        Casilla c22 = new Casilla(false, 1,4);
        Casilla c23 = new Casilla(false, 2,4);
        Casilla c24 = new Casilla(false, 3,4);
        Casilla c25 = new Casilla(false, 4,4);

        //fila1
        jardin[0][0] = c1;
        jardin[1][0] = c2;
        jardin[2][0] = c3;
        jardin[3][0] = c4;
        jardin[4][0] = c5;

        //fila2
        jardin[0][1] = c6;
        jardin[1][1] = c7;
        jardin[2][1] = c8;
        jardin[3][1] = c9;
        jardin[4][1] = c10;

        //fila3
        jardin[0][2] = c11;
        jardin[1][2] = c12;
        jardin[2][2] = c13;
        jardin[3][2] = c14;
        jardin[4][2] = c15;

        //fila4
        jardin[0][3] = c16;
        jardin[1][3] = c17;
        jardin[2][3] = c18;
        jardin[3][3] = c19;
        jardin[4][3] = c20;

        //fila5
        jardin[0][4] = c21;
        jardin[1][4] = c22;
        jardin[2][4] = c23;
        jardin[3][4] = c24;
        jardin[4][4] = c25;

        for(int j=0;j<alto;j++){
            for(int i = 0;i<ancho;i++){
                if(jardin[i][j].isPiso()){
                    System.out.print(" v |");
                } else {
                    System.out.print(" f |");
                }
            }
            System.out.print("\n");
        }

        backtracking_caballo back = new backtracking_caballo(jardin, c7);
        ArrayList<Casilla> res = back.bactracking();
        for(Casilla c : res){
            System.out.print("jardin["+c.getValorX()+"]["+c.getValorY()+"]"+" -> ");
        }
    }
}