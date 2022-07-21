import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Numa classe de testes, cada metodo é um teste diferente
public class ConversorTemperaturaTest {

    private ConversorTemperatura conversor = new ConversorTemperatura();

    @Test
    public void testCelsiusToFahrenheit() {
        double resultado = conversor.celsiusToFahrenheit(100);
        assertTrue(resultado == 212); // se o resultado da condição for true, o teste passa
    }

    @Test
    public void testFahrenheitToCelsius() {
        double resultado = conversor.fahrenheitToCelsius(212);
        assertEquals(100, resultado, 0.0);
        //compara o esperado com o resultado atual
    }
}
