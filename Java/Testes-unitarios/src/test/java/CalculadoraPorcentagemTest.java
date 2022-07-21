import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CalculadoraPorcentagemTest {
    public static void main(String[] args) {
        testCalculadoraPorcentagemValida();
        testCalculadoraPorcentagemInvalida();

    }

    public static void testCalculadoraPorcentagemValida() {
        CalculadoraPorcentagem calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(50, 1000.0);
        String resultadoEsperado = "50% de 1000,0 = 500,0";

        if(resultado.equals(resultadoEsperado)) { // compara caracter por caracter dentro de uma string(equals é um metodo de comparação de strings)
            System.out.println("Teste calculadora porcentagem valida: OK");
        } else {
            System.out.println("Teste calculadora porcentagem valida: FAIL");
        }

    }

    @Test
    public void testCalculadoraPorcentagemVal() {
        CalculadoraPorcentagem calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(50, 1000.0);
        String resultadoEsperado = "50% de 1000,0 = 500,0";

        assertEquals(resultadoEsperado, resultado);
    }




    public static void testCalculadoraPorcentagemInvalida() {
        CalculadoraPorcentagem calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(-40, 1000.0);

        if(resultado == null) {
            System.out.println("Teste calculadora porcentagem invalida: OK");
        } else {
            System.out.println("Teste calculadora porcentagem invalida: FAIL");
            System.out.println("Resultado: " + resultado);
        }
    }

    @Test
    public void testCalculadoraPorcentagemInval() {
        CalculadoraPorcentagem calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(-40, 1000.0);

        assertNull(resultado);
    }
}


// CalculadoraPorcentagem
// 1) percentual = 0 a 100
// 2) total = double
// "50% de 100 = 50"