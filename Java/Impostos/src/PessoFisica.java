public class PessoFisica extends Pessoa{

    private double gastosComSaude;

    public PessoFisica(String nome, double rendaAnual, double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public double calcularImposto() {
        double  imposto;
        if(getRendaAnual() < 20000){
            imposto = getRendaAnual() * 0.15;
        }else {
            imposto = getRendaAnual() * 0.25;
        }

        if(getGastosComSaude() > 0 ){
            imposto -= getGastosComSaude() * 0.5;
        }

        return imposto;
    }
}
