import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @Test
    public void testAdicionar() {
        assertEquals(5, calc.adicionar(2, 3));
        assertEquals(-1, calc.adicionar(-2, 1));
        assertEquals(0, calc.adicionar(0, 0));
    }

    @Test
    public void testSubtrair() {
        assertEquals(1, calc.subtrair(2, 1));
        assertEquals(-3, calc.subtrair(0, 3));
        assertEquals(0, calc.subtrair(0, 0));
    }

    @Test
    public void testMultiplicar() {
        assertEquals(6, calc.multiplicar(2, 3));
        assertEquals(-2, calc.multiplicar(-2, 1));
        assertEquals(0, calc.multiplicar(0, 5));

    }

    @Test
    public void testDividir() {
        assertEquals(2, calc.multiplicar(6, 3));
        assertEquals(-2, calc.multiplicar(-6, 3));
        assertEquals(0, calc.multiplicar(0, 1));

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.dividir(1, 0);
        });
        assertEquals("Não é possível dividir por zero", exception.getMessage());
    }
}


