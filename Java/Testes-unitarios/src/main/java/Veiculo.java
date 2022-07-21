import java.time.LocalDate;

public class Veiculo {
    private int rodas;
    private double tanque;
    private int ano;
    private double consumoCombustivel;
    private boolean ligado = false;

    ////////////////////////////////////////////////////////////////////////////////


    public Veiculo(int rodas, double tanque, int ano, double consumoCombustivel) {
        this.rodas = rodas;
        this.tanque = tanque;
        this.ano = ano;
        this.consumoCombustivel = consumoCombustivel; // km por litro
    }

    ////////////////////////////////////////////////////////////////////////////////
    public boolean viajar(double distancia) {
        if (ligado) {
            double consumo = distancia / consumoCombustivel; // L = km / km/L
            if (consumo < tanque) {
                if (distancia > 0) {
                    tanque -= consumo;
                    System.out.println("dirigindo meu carro...");
                    return true;
                } else {
                    System.out.println("Distância inválida");
                    return false;
                }
            } else {
                System.out.println("Tanque insuficiente");
                return false;
            }
        } else {
            System.out.println("O veículo não está ligado!");
            return false;
        }
    }

    public void ligar() {
        if (LocalDate.now().getYear() - ano <= 50 && tanque > 0) {
            ligado = true;
        } else {
            System.out.println("O veiculo não pode ser ligado");
        }

    }

    public void desligar() {
        ligado = false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getRodas() {
        return rodas;
    }

    public void setRodas(int rodas) {
        this.rodas = rodas;
    }

    public double getTanque() {
        return tanque;
    }

    public void setTanque(double tanque) {
        this.tanque = tanque;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getConsumoCombustivel() {
        return consumoCombustivel;
    }

    public void setConsumoCombustivel(double consumoCombustivel) {
        this.consumoCombustivel = consumoCombustivel;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
}
