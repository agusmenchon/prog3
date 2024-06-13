package org.example.ej7_cd;

import java.util.ArrayList;

public class greedy_cd {
//          ● Variante A: Maximizar la capacidad ocupada del disco CD.
//          ● Variante B: Maximizar la cantidad de canciones que se pueden grabar en el CD.
    private int capacidadMaxima;
    private ArrayList<Cancion> solucion;
    private Cancion[] canciones;

    public greedy_cd(int capacidadMaxima, Cancion[] canciones) {
        this.capacidadMaxima = capacidadMaxima;
        this.solucion = new ArrayList<>();
        this.canciones = canciones.clone();
    }

    public ArrayList<Cancion> greedy(String variante) {
        solucion.clear();
        int i = 0;
        int sumaEspacio = 0;
        while (i < canciones.length && sumaEspacio<capacidadMaxima) {
            Cancion c = null;
            if (variante.equals("A")) {
                c = seleccionA();
            } else if (variante.equals("B")) {
                c = seleccionB();
            }

            if (c != null && sumaEspacio+c.getTamanio()<=capacidadMaxima) {
                solucion.add(c);
                sumaEspacio+=c.getTamanio();
            }

            i++;
        }

        if (!solucion.isEmpty()) {
            return solucion;
        }
        return null;
    }
    private Cancion seleccionA(){
//        Variante A: Maximizar la capacidad ocupada del disco CD.
        Cancion cancionMayor = null;
        int cancionCapacidadMayor = 0;
        int j = 0;

        for(int i = 0;i<canciones.length; i++){
            if(canciones[i]!=null){
                if(canciones[i].getTamanio() > cancionCapacidadMayor){
                    cancionMayor = canciones[i];
                    cancionCapacidadMayor = canciones[i].getTamanio();
                    j = i;
                }
            }
        }

        if(cancionMayor!=null){
            canciones[j] = null;
            return cancionMayor;
        }

        return null;
    }
    private Cancion seleccionB(){
//        Variante B: Maximizar la cantidad de canciones que se pueden grabar en el CD.
//        Variante A: Maximizar la capacidad ocupada del disco CD.

        int capacidadMenor = Integer.MAX_VALUE;
        Cancion cancion_CapacidadMenor = null;
        int j = 0;

        for(int i = 0;i<canciones.length; i++){
            if(canciones[i]!=null){
                if(canciones[i].getTamanio() < capacidadMenor){
                    cancion_CapacidadMenor = canciones[i];
                    capacidadMenor = canciones[i].getTamanio();
                    j = i;
                }
            }
        }

        if(cancion_CapacidadMenor!=null){
            canciones[j] = null;
            return cancion_CapacidadMenor;
        }
        return null;
    }

    public void imprimirSolucion(ArrayList<Cancion> solucion){
        int sumaCanciones = 0;
        int sumaTotal = 0;
        for(Cancion c : solucion){
            System.out.println("Nombre: " + c.getNombre() + " - Tamanio: " + c.getTamanio());
            sumaCanciones++;
            sumaTotal+=c.getTamanio();
        }
        System.out.println("\nSuma canciones: " + sumaCanciones);
        System.out.println("Suma total tamanio: " + sumaTotal + " de " + capacidadMaxima + " espacio disponible");
    }

}
