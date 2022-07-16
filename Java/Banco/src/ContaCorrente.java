public class ContaCorrente  extends Conta{

    private final String atendimento = "Sem prioridades";

    public ContaCorrente(String titularConta, String numeroConta, String numeroAgencia, double saldo) {
        super(titularConta, numeroConta, numeroAgencia, saldo);

    }
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Essa conta tem atendimento do tipo: " + getAtendimento() );
    }

    public String getAtendimento() {
        return atendimento;
    }


}
