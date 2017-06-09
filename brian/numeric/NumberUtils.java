package brian.numeric;

import brian.functional.Functions;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public class NumberUtils {
    public static Number addMany(Number... nums) {
        return Functions.foldr((Number a, Number b) -> add(a, b), 0, nums);
    }
    public static Number subMany(Number... nums) {
        return Functions.foldr((Number a, Number b) -> sub(a, b), 0, nums);
    }
    public static Number mulMany(Number... nums) {
        return Functions.foldr((Number a, Number b) -> mul(a, b), 1, nums);
    }
    public static Number divMany(Number... nums) {
        return Functions.foldr((Number a, Number b) -> div(a, b), 1, nums);
    }

    public static Number add(Number n1, Number n2) {
        if (n1 instanceof Integer) {
            Integer num = (Integer) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Long) {
            Long num = (Long) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Double) {
            Double num = (Double) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Float) {
            Float num = (Float) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Byte) {
            Byte num = (Byte) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Short) {
            Short num = (Short) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        throw new IllegalArgumentException("Arguments must be one of the following classes: 'Integer', 'Long', 'Double', 'Float', 'Byte', or 'Short'.\n" +
                "Received: "+n1.getClass().getName()+" and "+n2.getClass().getName());
    }

    public static Number sub(Number n1, Number n2) {
        return add(n1, mul(-1, n2));
    }

    public static Number mul(Number n1, Number n2) {
        if (n1 instanceof Integer) {
            Integer num = (Integer) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Long) {
            Long num = (Long) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Double) {
            Double num = (Double) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Float) {
            Float num = (Float) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Byte) {
            Byte num = (Byte) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Short) {
            Short num = (Short) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        throw new IllegalArgumentException("Arguments must be one of the following classes: 'Integer', 'Long', 'Double', 'Float', 'Byte', or 'Short'.\n" +
                "Received: "+n1.getClass().getName()+" and "+n2.getClass().getName());
    }

    public static Number div(Number n1, Number n2) {
        if (n1 instanceof Integer) {
            Integer num = (Integer) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Long) {
            Long num = (Long) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Double) {
            Double num = (Double) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Float) {
            Float num = (Float) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Byte) {
            Byte num = (Byte) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Short) {
            Short num = (Short) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        throw new IllegalArgumentException("Arguments must be one of the following classes: 'Integer', 'Long', 'Double', 'Float', 'Byte', or 'Short'.\n" +
                "Received: "+n1.getClass().getName()+" and "+n2.getClass().getName());
    }

    /**
     * parseNum uses parametric polymorphism to parse <i>most</i> numbers.
     *
     * ints must fulfill following constraints:
     *     match the regex [-+]?\d+
     *     the numeric value must be in the range [-2147483648, 2147483647]
     *
     * longs must fulfill following constraints:
     *     match the regex [-+]?\d+
     *     the numeric value must be in the range [-9223372036854775808, 9223372036854775807]
     *
     * floats must fulfill following constraints:
     *     match the regex [-+]?(\d+|\d*\.\d+|\d+\.\d*)f
     *
     * doubles must fulfill following constraints:
     *     match the regex [-+]?(\d+|\d*\.\d+|\d+\.\d*)d?
     *
     *
     * @param num
     *        The number to parse
     * @return Either the parsed number, or an exception
     */
    public static Number parseNum(String num) {
        if (num.matches("[-+]?\\d+") &&
            num.charAt(0) == '-' ? "-2147483648".compareTo(num) >= 0: "2147483647".compareTo(num) <= 0) {
            return Integer.valueOf(num);
        }
        else if (num.matches("[-+]?\\d+") &&
                 num.charAt(0) == '-' ? "-9223372036854775808".compareTo(num) >= 0: "9223372036854775807".compareTo(num) <= 0)
            return Long.valueOf(num);
        else if (num.matches("[-+]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)f")) return Float.valueOf(num);
        else if (num.matches("[-+]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)d?")) return Double.valueOf(num);
        throw new NumberFormatException();
    }

    /**
     * Factorial function
     * @param n
     *        A number which is an element of the <i>Nonnegative Integers</i>
     * @return n! = foldr (*) 1 $ enumFromTo 1
     */
    public static Number factorial(Number n) {
        Number accumulator = n;
        if (n.intValue() == 0) return sub(n, sub(n,1));
        while (n.intValue() > 1) {
            n = sub(n,1);
            accumulator = mul(n, accumulator);
        }
        return accumulator;
    }

    public static boolean isStdNum(Number n) {
        boolean ret = n instanceof Integer;
        ret = n instanceof Long       || ret;
        ret = n instanceof Double     || ret;
        ret = n instanceof Float      || ret;
        ret = n instanceof Byte       || ret;
        ret = n instanceof Short      || ret;
        ret = n instanceof BigInteger || ret;
        ret = n instanceof BigDecimal || ret;
        return ret;
    }
}
