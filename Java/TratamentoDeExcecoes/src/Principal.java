import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("antes do lançamento da exceção");
        System.out.println("Digite um número: ");
        int numero = scan.nextInt(); // lança  a exceção: InputMismatchException
        System.out.println("Você digitou o número: " + numero);
        System.out.println("depois do lançamento da exceção");

        int[] numeros = {3, 5, 8, 10, 7};

        System.out.println("Digite um número de 0 a 4: ");
        int pos = scan.nextInt();

        System.out.println((" o numero da posição " + pos + " é: " + numeros[pos])); // ArrayIndexOutOfBoundsException

    }
}