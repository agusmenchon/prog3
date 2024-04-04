package org.example;

public class Main {
    public static void main(String[] args) {

        int arr[] = new int[50];

        for(int i = 0; i<arr.length;i++){
            arr[i] = i+1;
            System.out.print( arr[i] + "| ");
        }
        System.out.println(" ");


        //ej1
        if(isOrder(arr,arr.length-1)){
            System.out.println("Ej1: esta ordenado");
        } else {
            System.out.println("Ej1: no esta ordenado");
        }

        //ej2
        int elemento = 40;
        int i = searchElement(arr, elemento, 0,arr.length-1);
        System.out.println("Ej2: el int " + elemento + " esta en la posicion: " + i);

//      Ejercicio 3
        System.out.print("Ej3: el numero " + elemento + " en binario es: ");
        numberToBinary(elemento);

//      Ejercicio 4
        int j = 5;
        System.out.print( "\n" + "Ej4: los primeros " + j + " terminos de la secuencia de fibonacci son: ");
        mostrarFibonacci(j);
    }

//    Ejercicio 1
//    Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado y responda:
    public static boolean isOrder(int[] arr, int n){
        if (n == 0 || n == 1) {
            return true;
        }
        // Verificar si el último elemento es menor que el anterior
        if (arr[n - 1] < arr[n - 2]) {
            return false;
        }
        // Llamada recursiva con el tamaño del arreglo reducido en 1
        return isOrder(arr, n - 1);
    }

//    Ejercicio 2
//    Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
//    ascendentemente.
    public static int searchElement(int arr[], int elemento, int inicio,  int fin){
        int medio = (inicio+fin)/2; // pos 5

        if(elemento>arr[fin]){
            return -1;
        }

        if(elemento<arr[medio]){
            return searchElement(arr, elemento, inicio, medio);
        } else if (elemento > arr[medio]) {
            return searchElement(arr, elemento, medio, fin);
        } else {
            return medio;
        }
    }

//    Ejercicio 3
//    Implemente un algoritmo recursivo que convierta un número en notación decimal a su
//    equivalente en notación binaria.
    public static void numberToBinary(int n){
        if(n>=1){
            numberToBinary(n / 2);
            System.out.print(n%2 + " ");
        }
    }

//    Ejercicio 4
//    Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
//    Fibonacci.
//    Por ej. los 6 primeros términos son: 0 1 1 2 3 5
// Función recursiva para calcular el término de Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    // Función para mostrar los primeros N términos de la secuencia de Fibonacci
    public static void mostrarFibonacci(int N) {
        for (int i = 0; i < N; ++i) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

}