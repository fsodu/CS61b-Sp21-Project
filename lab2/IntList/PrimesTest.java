package IntList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PrimesTest {

    @Test
    public void isPrime() {
        assertEquals(true, Primes.isPrime(29));
        assertEquals(true, Primes.isPrime(31));
        assertEquals(true, Primes.isPrime(67));
        assertEquals(false, Primes.isPrime(66));
    }
}