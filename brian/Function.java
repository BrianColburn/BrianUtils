package brian;

import java.math.BigInteger;

/**
 * Created by brian on 3/11/17.
 */
public class Function {
    /**
     * This should really be in the standard library, but it's not.
     * @param n
     *        A number which is an element of the <i>Nonnegative Integers</i>
     * @return n!
     */
    public static BigInteger factorial(Integer n) {
        return n.equals(0) ? BigInteger.ONE : factorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    /**
     * Calculates the magic number for an <i>n</i>D matrix
     * @param n
     *        The dimension of a matrix
     * @return .5n(n^2 + 1)
     */
    public static Integer magicConstant(Integer n) {
        return n * (n * n + 1) / 2;
    }

    public static Boolean evenQ(Integer n) {
        return n % 2 == 0;
    }

    public static Boolean oddQ(Integer n) {
        return !evenQ(n);
    }
}
