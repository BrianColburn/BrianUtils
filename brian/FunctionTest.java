package brian;

import brian.functional.Functions;
import brian.numeric.NumberUtils;
import brian.numeric.domain.Countable;
import brian.utils.list.LongList;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created by Colburn2013 on 5/31/2017.
 */
public class FunctionTest {
    public static void main(String... args) throws Exception {
        LongList nums = new LongList(new Countable().stream().limit(10).mapToLong(n -> n));
        System.out.println(Functions.map(n -> 2 * n, nums));
        System.out.println(Functions.foldr(NumberUtils::add, 0, nums));
        System.out.println(nums.sum());
        System.out.println(Functions.compose(
                (Double a) -> {
                    System.out.println("Last function");
                    return a + 1.5;
                },
                (Double b) -> {
                    System.out.println("Second function");
                    return b / 2;
                },
                (Double c) -> {
                    System.out.println("First function");
                    return c * 3;
                }).apply(5d));
        System.out.println(Arrays.toString(Functions.class.getDeclaredMethods()[0].getGenericParameterTypes()));
    }
}
