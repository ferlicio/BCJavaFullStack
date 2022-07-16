import java.util.ArrayList;
import java.util.List;

public class Contribuicao {
    public static void main(String[] args) {
        Pessoa pf1 = new PessoFisica("Guilherme",10000,500);
        PessoFisica pf2 = new PessoFisica("Tiago",50000,2000);
        //System.out.printf("%s%s%.2f%n", pf1.getNome(), " vai pagar o valor de: R$",pf1.calcularImposto());

        Pessoa pj1 = new PessoaJuridica("SoulCode", 500000, 45);
        PessoaJuridica pj2 = new PessoaJuridica("TNT", 1000000,150);
        //System.out.printf("%s%s%.2f%n", pj1.getNome(), " vai pagar o valor de: R$",pj1.calcularImposto());

        //int[] lista = {5,7,8,9};

        List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

        listaPessoas.add(pf1);
        listaPessoas.add(pf2);
        listaPessoas.add(pj1);
        listaPessoas.add(pj2);

        double soma = 0;

        for(Pessoa p:listaPessoas){
            System.out.printf("%s%s%.2f%n",p.getNome()," vai pagar de imposto o valor de: R$ ",p.calcularImposto());
            soma = soma + p.calcularImposto();
        }
        System.out.printf("%s%.2f", "O total de imposto a ser pago é de: R$ ", soma);


    }
}
