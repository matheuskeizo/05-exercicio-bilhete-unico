package Teste;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        double[] x = new double[5];
        carrega(x);
        saida(x);
    }

    public static void carrega(double[] x){
        Scanner e = new Scanner(System.in);
        for(int i=0;i<x.length;i++){
            System.out.println("Carregue o X"+i+":");
            x[i]=e.nextDouble();
        }
    }

    public static void saida(double[] x){
        for (int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
        for(double i:x){
            System.out.println(i);
        }

    }

}
