package Aula2;

import java.util.Scanner;

public class metodos {

    public static void main(String[] args) {
        impressao();
        mensagem("Java é vida!");
        System.out.println("o dobro do número é: " + dobro(10));
        for(int i = 1; i < 11; i++){
            System.out.println("O Fatorial de " + i +" é: " + fatorial(i));
        }

        System.out.println("o resultado é: " + calc(2,3));
        System.out.println("o resultado é: " + calc(2.5,3.1));
        System.out.println("o resultado é: " + calc(2,3));

        double[] notas = {9.5, 5.8, 7.9, 9, 8.7, 7};
        System.out.println("A média das notas é: " + calc(notas));
        System.out.printf("%s%.2f%s","A média das notas é: ", calc(notas), "mais alguma coisa");
    }

    //métodos sem retorno e sem parâmetros
    public static void impressao(){
        System.out.println("Java é lindo!");
    }

    //métodos sem retorno mas com parâmetros
    public static void mensagem(String msg){
        System.out.println(msg);
    }

    //método com retorno
    public static int dobro(int numero){
        return numero * 2;
    }

    public static int fatorial(int numero){

        int fatorial = 1;
        for(int cont = numero; cont > 0; cont--){
            fatorial *= cont;
        }
        return fatorial;
    }

    // sobrecarga de métodos

    public static int calc(int num1, int num2){
        return num1 + num2;
    }

    public static double calc(double num1, double num2){
        return num1 + num2;
    }

    public static int calc(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }

    public static double calc(double[] numeros){
        double soma = 0;
        for(double n:numeros){
            soma += n;
        }
        return soma/numeros.length;
    }


}
