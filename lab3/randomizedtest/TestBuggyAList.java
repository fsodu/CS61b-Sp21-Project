package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();

        a.addLast(5);
        a.addLast(6);
        a.addLast(7);

        b.addLast(5);
        b.addLast(6);
        b.addLast(7);

        assertEquals(a.size(), b.size());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                broken.addLast(randVal);
                System.out.println("broken addLast(" + randVal + ")");
                assertEquals(correct.getLast(), broken.getLast());
            } else if (operationNumber == 1) {
                // size
                int size1 = correct.size();
                int size2 = broken.size();
                System.out.println("correct size: " + size1);
                System.out.println("broken size: " + size2);
                assertEquals(size1, size2);

            } else if (operationNumber == 2) {
                // getLast
                int last1;
                int last2;
                if (correct.size() == 0) {
                    System.out.println("correct empty list!");
                } else {
                    last1 = correct.getLast();
                    System.out.println("correct last = " + last1);
                    if (broken.size() == 0) {
                        System.out.println("broken empty list!");
                    } else {
                        last2 = broken.getLast();
                        System.out.println("broken last = " + last2);
                        assertEquals(last1, last2);

                    }
                }

            } else if (operationNumber == 3) {
                // removeLast
                if (correct.size() == 0) {
                    System.out.println("correct empty list!");
                } else {
                    correct.removeLast();
                    System.out.println("correct removed last");
                }
                if (broken.size() == 0) {
                    System.out.println("broken empty list!");
                } else {
                    broken.removeLast();
                    System.out.println("broken removed last");
                }
            }
        }
    }

}
