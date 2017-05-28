import brian.Prime;

/**
 * Created by Colburn2013 on 5/28/2017.
 */
public class PrimeTest {
    public static void main(String... args) {
        Long start = System.nanoTime();
        System.out.println(new Prime().primeQ.test(19*23) + " " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println(new Prime().primeQ.test(101) + " " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println(new Prime().primeQ.test(41*43) + " " + (System.nanoTime() - start));
    }
}
