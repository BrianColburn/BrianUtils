import brian.functional.InfList;
import brian.numeric.domain.Natural;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Colburn2013 on 5/27/2017.
 */
public class InfListTest {
    public static void main(String... args) {
        InfList<Long> rList = new InfList<>(new Natural().iterator());
        long start = System.nanoTime();
        System.out.println(rList.get(20_000_000));
        System.out.println(System.nanoTime()-start);/*/
        for (int i = 1; i < 10000; i*=2)
        System.out.println(i+Arrays.toString(new BigInteger(i+"").toByteArray()));*/
    }
}
