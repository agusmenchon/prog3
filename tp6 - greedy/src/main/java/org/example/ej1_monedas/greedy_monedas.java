package org.example.ej1_monedas;

import java.util.ArrayList;

public class greedy_monedas {

    public ArrayList<Integer> greedy(int[] monedas, int pago){
        ArrayList<Integer> r = new ArrayList<>();
//        int i = 0;
        int suma = 0;

        while(suma<pago){
            int moneda = seleccionar(monedas, suma, pago);
            r.add(moneda);
            suma+=moneda;
        }

        if(suma == pago){
            return r;
        } else {
            return null;
        }
    }

    public Integer seleccionar(int[] monedas, int suma, int pago){
        for(int j = 0;j<monedas.length;j++){
            if(suma+monedas[j]<=pago){
                return monedas[j];
            }
        }
        return -1;
    }

    public void imprimirResultado(ArrayList<Integer> res){
        int m100 = 0;
        int m25 = 0;
        int m10 = 0;
        int m5 = 0;
        int m1 = 0;

        for(Integer i : res){
            switch(i){
                case 100: m100++;
                    break;
                case 25: m25++;
                    break;
                case 10: m10++;
                    break;
                case 5: m5++;
                    break;
                case 1: m1++;
                    break;
            }
        }

        if(m100!=0){
            System.out.println(m100 + " de monedas de 100");
        }
        if(m25!=0) {
            System.out.println(m25 + " de monedas de 25");
        }
        if(m10!=0){
            System.out.println(m10 + " de monedas de 10");
        }
        if(m5!=0){
            System.out.println(m5 + " de monedas de 5");
        }
        if(m1!=0){
            System.out.println(m1 + " de monedas de 1");
        }
    }
}
