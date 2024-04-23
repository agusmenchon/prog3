package org.example;

public class Main {
    public static void main(String[] args) {

        int arr[] = new int[20];

        imprimir(arr);
        System.out.println(" ");


        //ej1
        if (isOrder(arr, arr.length - 1)) {
            System.out.println("Ej1: esta ordenado");
        } else {
            System.out.println("Ej1: no esta ordenado");
        }

        //ej2
        int elemento = 10;
        int i = searchElement(arr, elemento, 0, arr.length - 1);
        System.out.println("Ej2: el int " + elemento + " esta en la posicion: " + i);

//      Ejercicio 3
        System.out.print("Ej3: el numero " + elemento + " en binario es: ");
        numberToBinary(elemento);

//      Ejercicio 4
        int j = 5;
        System.out.print("\n" + "Ej4: los primeros " + j + " terminos de la secuencia de fibonacci son: ");
        mostrarFibonacci(j);

//      Ejercicio 5
        int[] arr2 = {-3, 8, 5, 2, 4, 3, 10};
        imprimir(arr2);
        ej5(0, arr2);

        //Ejercicio 6:
        int[] arr3 = {26,54,93,17,77,31,44,55,20};
        imprimir(arr3);
        quickSort(arr3, 0, arr3.length-1);
        System.out.print("Ej6 - bubble Sort: ");
        imprimir(arr3);
    }
    public static void imprimir(int [] arr){
        for (int h = 0; h < arr.length; h++) {
            System.out.print(+ arr[h] + " | ");
        }
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

//    Función recursiva para calcular el término de Fibonacci
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

//    Ejercicio 5
//    Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
//    determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
//    cuál se encuentra, es decir, A[i] = i.

//1. Construir un algoritmo recursivo que responda a dicha verificación.
//2. Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10]
    public static boolean ej5(int n, int [] arr){
        if(arr[n] == n){
            System.out.println("\n" + "Ej5: El elemento " + n + " se encuentra en la posicion arr[" + n + "]");
            return true;
        } else {
            ej5(n+1, arr);
        }
        return false;
    }

//    Ejercicio 6
//    Implemente un algoritmo de ordenamiento por selección en un arreglo.
    public static void selectionSort(int[] arr) {
        int aux;
        int min;
        for(int i = 0;i<arr.length;i++){
            min = i;
            for(int j = i+1; j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }

//    Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
//    ● ¿Qué complejidad big-O tienen estos algoritmos?
    public static void bubbleSort(int [] arr){
        int aux;
        for(int i = 0; i<arr.length-1; i++){
            for(int j = 0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    aux = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }
    // O(n^2)

//    Ejercicio 7
//    Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
    public static void mergeSort(int [] arr, int inicio, int fin){}

    public static void ordenar(int low, int middle, int high){}

//    Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
//            ● ¿Cuál es su complejidad en el peor caso?
//            ● ¿Cuál es su complejidad promedio?
    public static void quickSort(int [] arr, int inicio, int fin){
        if(inicio>=fin) return;

        int pivote = arr[inicio];
        int aux;
        int elemIzq = inicio+1;
        int elemDer = fin;

        while(elemIzq<=elemDer){
            while(elemIzq<=fin && arr[elemIzq]<pivote){
                elemIzq++;
            }
            while(elemDer>inicio && arr[elemDer]<pivote){
                elemDer--;
            }
            if(elemIzq<elemDer){
                aux = arr[elemDer];
                arr[elemDer] = arr[elemIzq];
                arr[elemIzq] = aux;
                elemIzq++;
                elemDer--;
            }
        }
        if(elemDer>inicio){
            aux = arr[inicio];
            arr[inicio]=arr[elemDer];
            arr[elemDer]=aux;
        }

        quickSort(arr, inicio, elemDer-1);
        quickSort(arr, elemDer+1, fin);
    }
}