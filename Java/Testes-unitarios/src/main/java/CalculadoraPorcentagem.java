public class CalculadoraPorcentagem {

    public String calcular(int percentual, double valor) {
        if(percentual < 0 || percentual > 100) {
            return null;
        }

        double resultado = valor * (percentual / 100.0);
        //return percentual + "% de " + valor + " = " + resultado;
        return String.format("%d%% de %.1f = %.1f", percentual, valor, resultado);
    }

}
