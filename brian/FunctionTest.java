package brian;

import brian.functional.Functions;
import brian.numeric.NumberUtils;
import brian.numeric.domain.Countable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Colburn2013 on 5/31/2017.
 */
public class FunctionTest {
    public static void main(String... args) {
        List<Long> nums = new Countable().stream().limit(10).collect(Collectors.toList());
        System.out.println(Functions.map(n -> 2 * n, nums));
        System.out.println(Functions.foldr(NumberUtils::add, 0, nums));
    }
}
