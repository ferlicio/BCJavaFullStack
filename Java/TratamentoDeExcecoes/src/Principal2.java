import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um número: ");
        try {
            long numero = scan.nextLong();
            System.out.println("O número digitado foi: " + numero);
        }catch (Exception e) {
            System.out.println("Erro: você não digitou um número válido" + e.getMessage());
        }finally {
            System.out.println("Obrigatoriamente, você passa por aqui");
        }
    }
}
