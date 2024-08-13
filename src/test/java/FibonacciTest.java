import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.AssertionsKt.assertDoesNotThrow;

public class FibonacciTest {

    private final Fibonacci fib = new Fibonacci();

    @Test
    public void testFibonacci() {
        Assert.assertEquals(0, fib.fibonacci(0));
        Assert.assertEquals(1, fib.fibonacci(1));
        Assert.assertEquals(2, fib.fibonacci(2));
        Assert.assertEquals(3, fib.fibonacci(3));
        Assert.assertEquals(4, fib.fibonacci(4));
        Assert.assertEquals(5, fib.fibonacci(5));

    }

    @Test
    public void testFibonacciNegative() {
        //Método Fibonacci não lida com valores negativos
        Assert.assertThrows(StackOverflowError.class, () -> {
            fib.fibonacci(-1);
        });
    }

    @Test
    public void testFibonacciLarge() {
    //Teste com númeiros grandes pode ser muito lento para Fibonacci recursivo
        long startTime = System.currentTimeMillis();
        try {
            fib.fibonacci(20);
        } catch (Exception e) {
            Assert.fail("Método falhou" + e.getMessage());
        }
        long duration = System.currentTimeMillis() - startTime;
        Assert.assertTrue("Tempo de execução muito longo", duration < 1000);

    }
}
