package Aula1;

import java.util.Scanner;

public class Lista1 {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Alô Java");

        //existem essas duas formas de declarar um vetor

        int[] numeros2 = {10,20,30,40,50};
        int[] numeros = new int[5];
        numeros[0] =10;
        numeros[1] =20;
        numeros[2] =30;
        numeros[3] =40;
        numeros[4] =50;

        System.out.println("Na posição 4, temos o elemento " +numeros[4]);
        System.out.println("No meu vetor existem " + numeros.length + " elementos" );

        for(int posicao = 0 ; posicao < numeros.length; posicao++){
            System.out.println("o elemento " + (posicao +1) + " é " + numeros[posicao]);
        }


//        char[] gabarito = {'a', 'b','e','d','b'};
//        char[] respostas = new char[5];
//
//        for(int pos = 0; pos < gabarito.length; pos++){
//            System.out.println("Digite a resposta da pergunta " + (pos+1) + " : ");
//            respostas[pos] = leitor.next().charAt(0);
//        }
//
//        int nota = 0;
//
//        for(int pos = 0; pos < respostas.length; pos++){
//            if(gabarito[pos] == respostas[pos]){
//                nota++;
//            }
//        }
//
//        System.out.println("Você acertou " + nota + " perguntas");

     String[] palavras = {"casa", "papel", "mercado","cachorro", "gato"};

        for(String elemento:palavras){
            System.out.println(elemento);
        }

    int[] meusNumeros = {1,45,76,4,89,10};
        for(int num:meusNumeros){
            System.out.println(num);
        }


    }
}
