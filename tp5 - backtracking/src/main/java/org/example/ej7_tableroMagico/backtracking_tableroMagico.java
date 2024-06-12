package org.example.ej7_tableroMagico;

public class backtracking_tableroMagico {
    private int[][] tablero;
//    private int k;
//    private int s;

    public backtracking_tableroMagico(int[][] tablero) {
        this.tablero = tablero;
//        this.k = k;
//        this.s = s;
    }

    public void backtracking() {
        int fila = 0;
        int col = tablero.length / 2;
        int num = 1;
        int f = 0;
        int c = 0;

        for(int i = num; i<=tablero.length*tablero.length;i++){

            tablero[fila][col] = num;
            num++;
            f = fila;
            c = col;
            fila--;
            col++;
            if (fila == -1) {
                fila = tablero.length - 1;
            }
            if (col == tablero.length) {
                col = 0;
            }
            if (tablero[fila][col] != 0) {
                fila = f;
                fila++;
                col = c;
            }
        }
        imprimirTablero();
    }

    public void imprimirTablero(){
        for(int i = 0;i<tablero.length;i++){
            System.out.print("| ");
            for(int j=0;j<tablero.length; j++){
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.print("\n");
        }
    }
}
