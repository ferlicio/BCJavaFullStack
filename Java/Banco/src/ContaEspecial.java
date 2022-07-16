public class ContaEspecial extends Conta {
    private final String atendimento = "Com prioridade";
    private double limiteEspecial;
    private  double saldoLimite;

    public ContaEspecial(String titularConta, String numeroConta,
                         String numeroAgencia, double saldo, double limiteEspecial) {
        super(titularConta, numeroConta, numeroAgencia, saldo);
        this.limiteEspecial = limiteEspecial;
        this.saldoLimite = limiteEspecial;
    }


    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Essa conta tem um limite especial de: " + getLimiteEspecial());
        System.out.println("Essa conta tem atendimento do tipo: " + getAtendimento() );
    }

    @Override
    public void sacar(double valor){
        System.out.println("-------" + this.getTitularConta() + "---------------");
        if(valor <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque efetuado com sucesso!");
            System.out.println("Seu novo saldo é: " + this.getSaldo());
        }else if((this.getSaldo() + this.getSaldoLimite()) > valor){
            System.out.println("Seu saldo é insuficiente, você usará o seu limite especial");
            this.setSaldoLimite(this.getSaldoLimite() - (valor - this.getSaldo()));
            this.setSaldo(this.getSaldo() - valor);

            System.out.println("Saque efetuado com sucesso. Seu novo saldo é: " + this.getSaldo());
            System.out.println("Seu novo saldo do limite é: " + this.getSaldoLimite());

        }else{
            System.out.println("Saldo insuficente para o saque");
        }
    }
    @Override
    public void depositar(double valor){
        System.out.println("-------" + this.getTitularConta() + "---------------");
        if (this.getSaldo() >= 0){
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Saque efetuado com sucesso!");
            System.out.println("Seu novo saldo é: " + this.getSaldo());
        }else {
            this.setSaldo(this.getSaldo() + valor);
            if(this.getSaldo() >=0 ) {
                //valor = valor - (this.getLimiteEspecial() - this.getSaldoLimite());
                this.setSaldoLimite(this.getLimiteEspecial());
            }
            else{
                this.setSaldoLimite(this.getSaldoLimite() + valor);

            }
            System.out.println("Depósito efetuado com sucesso. Seu novo saldo é: " + this.getSaldo());
            System.out.println("Seu novo saldo do limite é: " + this.getSaldoLimite());
        }

    }

    //->saldo - valor que você tem na conta
    //->limiteEspecial - fixo - o máximo que você pode utilizar além do saldo
    //->saldoLimite (saldo do Limite especial) - o valor que ainda tem disponível para ser utilizado além do saldo

    // na de depositar ->
    //-> se saldo não negativo - deposito é normal - acrescente o valor no saldo

    // -> se saldo negativo 1) o depósito é maior que saldo do limite especial
    //                      2) o depósito é menor que saldo o limite especial

    public String getAtendimento() {
        return atendimento;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    public double getSaldoLimite() {
        return saldoLimite;
    }

    public void setSaldoLimite(double saldoLimite) {
        this.saldoLimite = saldoLimite;
    }
}
