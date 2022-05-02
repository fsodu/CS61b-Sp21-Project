package IntList;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);

        IntList lst2 = IntList.of(14, -15, 1, 17, 18, 20, 11, 11);
        boolean changed2 = IntListExercises.squarePrimes(lst2);
        assertEquals("14 -> -15 -> 1 -> 289 -> 18 -> 20 -> 121 -> 121", lst2.toString());
        assertTrue(changed2);

        IntList lst3 = IntList.of(0, 11, 17, 16, 18);
        boolean changed3 = IntListExercises.squarePrimes(lst3);
        assertEquals("0 -> 121 -> 289 -> 16 -> 18", lst3.toString());
        assertTrue(changed3);

        IntList lst4 = IntList.of(0);
        boolean changed4 = IntListExercises.squarePrimes(lst4);
        assertEquals("0", lst4.toString());
        assertFalse(changed4);


    }


}
