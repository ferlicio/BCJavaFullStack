import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    static int totalTests = 0;

    static DateTimeFormatter timeFormatter;

    @BeforeAll
    static void beforeAll() {
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Total de testes: " + totalTests);
    }

    @BeforeEach
    public void beforeEach() {
        totalTests++;
        System.out.println("[START] Teste #" + totalTests + " - " + timeFormatter.format(LocalDateTime.now()));
    }

    @AfterEach
    public void afterEach() {
        System.out.println("[END] Teste #" + totalTests + " - " + timeFormatter.format(LocalDateTime.now()));
    }


    @Test
    public void testViajarLigado() {
        Veiculo veiculo = new Veiculo(4, 10, 2018, 30);
        veiculo.ligar();
        assertTrue(veiculo.viajar(19));
    }
    @Test
    public void testViajarContaCorretamente() {
        Veiculo veiculo = new Veiculo(4, 10, 2018, 10);
        veiculo.ligar();
        veiculo.viajar(5);
        assertEquals(9.5, veiculo.getTanque(),0.0);
    }
    @Test
    public void testViajarDesligado() {
        Veiculo veiculo = new Veiculo(4, 10, 2018, 30);
        assertFalse(veiculo.viajar(10));
    }
    @Test
    public void testViajarSemCombustivel() {
        Veiculo veiculo = new Veiculo(4, 0, 2018, 30);
        veiculo.ligar();
        assertFalse(veiculo.viajar(19));
    }
    @Test
    public void testViajarValorNegativo() {
        Veiculo veiculo = new Veiculo(4, 10, 2018, 30);
        veiculo.ligar();
        assertFalse(veiculo.viajar(-19));
    }

    @Test
    public void testLigar() {
        Veiculo veiculo = new Veiculo(4, 10, 2000, 10);
        veiculo.ligar();
        assertTrue(veiculo.isLigado());
    }

    @Test
    public void testDesligar() {
        Veiculo veiculo = new Veiculo(4, 50, 2018, 10);
        veiculo.desligar();
        assertFalse(veiculo.isLigado());
    }

    @Test
    public void testLigarDesligar() {
        Veiculo veiculo = new Veiculo(4, 50, 2018, 10);
        veiculo.ligar();
        veiculo.desligar();
        assertFalse(veiculo.isLigado());
    }
}