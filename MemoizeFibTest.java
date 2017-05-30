import brian.functional.Functions;
import brian.functional.RecursiveFunction;
import brian.utils.list.DoubleList;

/**
 * Created by Colburn2013 on 5/24/2017.
 */
public class MemoizeFibTest {
    public static void main(String... args) {
        RecursiveFunction<Integer, Integer> fib = new RecursiveFunction<>();
        fib.function = n -> n >> 1 < 1 ? 1 : fib.apply(n - 1) + fib.apply(n - 2);
        DoubleList time = new DoubleList();
        DoubleList mtime = new DoubleList();
        System.out.println("Starting fib");
        for (int i = 0; i < 1000; i++) {
            Long start = System.nanoTime();
            fib.apply(30);
            time.add((double) (System.nanoTime() - start));
        }
        System.out.println(time.mean());
        Functions.memoize(fib);
        System.out.println("Starting memoized fib");
        for (int i = 0; i < 1000; i++) {
            Long start = System.nanoTime();
            fib.apply(30);
            mtime.add((double) (System.nanoTime() - start));
        }
        System.out.println(mtime.mean());
        System.out.println(time.mean()/mtime.mean() + "\n");
    }
}
