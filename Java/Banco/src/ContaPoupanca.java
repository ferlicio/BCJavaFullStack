public class ContaPoupanca extends Conta{

    private final double rendimento = 2.5;

    public ContaPoupanca(String titularConta, String numeroConta, String numeroAgencia, double saldo) {
        super(titularConta, numeroConta, numeroAgencia, saldo);
    }


    public double getRendimento() {
        return rendimento;
    }
}
