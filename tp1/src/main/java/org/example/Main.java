package org.example;


import org.example.TP1.SimpleLinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //EJERCICIO 1
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

        list.addLast(5);
        list.addLast(3);
        list.addLast(4);
        list.addLast(8);

        SimpleLinkedList<Integer> list2 = new SimpleLinkedList<Integer>();

        list2.addLast(8);
        list2.addLast(3);
        list2.addLast(5);
        list2.addLast(1);

        System.out.println("Lista 1: " + list.toString());
        System.out.println("Lista 2: " + list2.toString());

        Integer g = list.get(2);
        System.out.println("posicion 2 de la lista: " + g);

        /*
        Ejercicio 2
        Considerando la implementación de la lista vinculada realizada en el ejercicio anterior, comparar la
        complejidad computacional contra un array en las siguientes operaciones:

        1. Insertar al principio.
            Array --> O(n)
            SimpleLinkedList --> O(1)

        2. Buscar un elemento en una posición.
            Array --> O(n) donde N es la cantidad de elementos del array
            SimpleLinkedList --> O(n)

        3. Determinar la cantidad de elementos.
            Array --> O(n) donde N es la cantidad de elementos del array
            SimpleLinkedList --> O(1) guardando en una variable de instancia size()

        4. Borrar un elemento de una posición determinada.
            Array --> O(n) donde N es la cantidad de elementos del array
            SimpleLinkedList --> O(n)

        */

        // Ejercicio 3
        Integer i = 8;
        Integer indice = list.indexOf(i);
        System.out.println("el elemento '" + i + "' esta en la posicion: " + indice);

        // Ejercicio 4
        System.out.print("Ejercicio 4 iterator (lista 1) ");
        for(Integer l: list){
            System.out.print(l + " | ");
        }
        System.out.println("");

        // Ejercicio 5
        SimpleLinkedList l3 = list.concatListEj5(list2);
        System.out.println("Ejercicio 5 " + l3.toString());

        // Ejercicio 6
        SimpleLinkedList l4 = list.concatListEj6(list2);
        System.out.println("Ejercicio 5 " + l4.toString());
    }
}