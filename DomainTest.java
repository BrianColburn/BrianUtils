import brian.numeric.domain.Countable;
import brian.numeric.domain.Integral;
import brian.numeric.domain.Natural;
import brian.numeric.domain.Rational;

/**
 * Created by 197509 on 5/24/2017.
 */
public class DomainTest {
    public static void main(String... args) {
        new Countable().stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        new Natural().stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        new Integral().stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        new Rational().stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        for (double i : new double[] {1, 0, -1, 2.5}) {
            System.out.print(Countable.contains(i) + " ");
            System.out.print(Natural.contains(i) + " ");
            System.out.print(Integral.contains(i) + " ");
            System.out.println(Rational.contains(i));
        }
    }
}
