import java.util.Scanner;

public class Leitura {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um número: ");

        int numero = 0;

        numero = scan.nextInt();

        System.out.println("O número digitado foi: " + numero);

        String nome = "";
        System.out.println("Digite um Nome: ");

        nome = scan.next();
        System.out.println("O nome digitado foi: " + nome);





       
    }
}
