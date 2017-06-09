import brian.functional.InfList;
import brian.numeric.domain.Natural;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
//import java.math.MutableBigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Colburn2013 on 5/27/2017.
 */
public class InfListTest {
    public static void main(String... args) throws Exception {
        /*InfList<Long> rList = new InfList<>(new Natural().iterator());
        long start = System.nanoTime();
        System.out.println(rList.get(20_000_000));
        System.out.println(System.nanoTime()-start);*/
        List test = new ArrayList();
        System.out.println(test);
        ArrayList.class.getDeclaredMethod("add", Object.class).invoke(test,1);
        System.out.println(test);
        System.out.println(BigInteger.valueOf(123));
        Field mag = BigInteger.class.getDeclaredField("mag");
        mag.setAccessible(true);
        //System.out.println(Arrays.toString((int[]) mag.get(new BigInteger((long) (1 << 5)*Integer.MAX_VALUE+(1 << 5)+""))));
        BigInteger num = BigInteger.valueOf(123);
        System.out.println(Arrays.toString((int[]) mag.get(num)));
        Field signum = BigInteger.class.getDeclaredField("signum");
        signum.setAccessible(true);
        Method divide = Class.forName("java.math.MutableBigInteger").getDeclaredMethod("divide", Class.forName("java.math.MutableBigInteger"), Class.forName("java.math.MutableBigInteger"));
        divide.setAccessible(true);
        Method toBigInteger = Class.forName("java.math.MutableBigInteger").getDeclaredMethod("toBigInteger", int.class);
        toBigInteger.setAccessible(true);
        Constructor defaultCons = Class.forName("java.math.MutableBigInteger").getDeclaredConstructor();
        Constructor intArrCons  = Class.forName("java.math.MutableBigInteger").getDeclaredConstructor(int[].class);
        defaultCons.setAccessible(true);
        intArrCons.setAccessible(true);


        int digitsPerLong[] = {0, 0,
                62, 39, 31, 27, 24, 22, 20, 19, 18, 18, 17, 17, 16, 16, 15, 15, 15, 14,
                14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12};
        BigInteger longRadix[] = {null, null,
                BigInteger.valueOf(0x4000000000000000L), BigInteger.valueOf(0x383d9170b85ff80bL),
                BigInteger.valueOf(0x4000000000000000L), BigInteger.valueOf(0x6765c793fa10079dL),
                BigInteger.valueOf(0x41c21cb8e1000000L), BigInteger.valueOf(0x3642798750226111L),
                BigInteger.valueOf(0x1000000000000000L), BigInteger.valueOf(0x12bf307ae81ffd59L),
                BigInteger.valueOf( 0xde0b6b3a7640000L), BigInteger.valueOf(0x4d28cb56c33fa539L),
                BigInteger.valueOf(0x1eca170c00000000L), BigInteger.valueOf(0x780c7372621bd74dL),
                BigInteger.valueOf(0x1e39a5057d810000L), BigInteger.valueOf(0x5b27ac993df97701L),
                BigInteger.valueOf(0x1000000000000000L), BigInteger.valueOf(0x27b95e997e21d9f1L),
                BigInteger.valueOf(0x5da0e1e53c5c8000L), BigInteger.valueOf( 0xb16a458ef403f19L),
                BigInteger.valueOf(0x16bcc41e90000000L), BigInteger.valueOf(0x2d04b7fdd9c0ef49L),
                BigInteger.valueOf(0x5658597bcaa24000L), BigInteger.valueOf( 0x6feb266931a75b7L),
                BigInteger.valueOf( 0xc29e98000000000L), BigInteger.valueOf(0x14adf4b7320334b9L),
                BigInteger.valueOf(0x226ed36478bfa000L), BigInteger.valueOf(0x383d9170b85ff80bL),
                BigInteger.valueOf(0x5a3c23e39c000000L), BigInteger.valueOf( 0x4e900abb53e6b71L),
                BigInteger.valueOf( 0x7600ec618141000L), BigInteger.valueOf( 0xaee5720ee830681L),
                BigInteger.valueOf(0x1000000000000000L), BigInteger.valueOf(0x172588ad4f5f0981L),
                BigInteger.valueOf(0x211e44f7d02c1000L), BigInteger.valueOf(0x2ee56725f06e5c71L),
                BigInteger.valueOf(0x41c21cb8e1000000L)};
        String zeros[] = new String[64];
        zeros[63] =
                "000000000000000000000000000000000000000000000000000000000000000";
        for (int i=0; i < 63; i++)
            zeros[i] = zeros[63].substring(0, i);


        // Compute upper bound on number of digit groups and allocate space
        int maxNumDigitGroups = (4*((int[]) mag.get(num)).length + 6)/7;
        String digitGroup[] = new String[maxNumDigitGroups];

        // Translate number to string, a digit group at a time
        BigInteger tmp = num.abs();
        int numGroups = 0;
        while (((int)signum.get(tmp)) != 0) {
            BigInteger d = longRadix[10];

            Object q = defaultCons.newInstance(),
                    a = intArrCons.newInstance(new Object[] {(int[])mag.get(tmp)})/*new MutableBigInteger((int[])mag.get(tmp))*/,
                    b = intArrCons.newInstance(new Object[] {(int[])mag.get(tmp)})/*new MutableBigInteger((int[])mag.get(d))*/;
            Object r = divide.invoke(a, b,q); //a.divide(b, q);        // This is the first part where the effects of my code differs from BigInteger's code...
                                                                       // For some reason it returns 0 instead of 123
            BigInteger q2 = (BigInteger) toBigInteger.invoke(q, (int)signum.get(tmp) * (int)signum.get(d));//q.toBigInteger((int)signum.get(tmp) * (int)signum.get(d));
            BigInteger r2 = (BigInteger) toBigInteger.invoke(r, (int)signum.get(tmp) * (int)signum.get(d));//r.toBigInteger((int)signum.get(tmp) * (int)signum.get(d));

            digitGroup[numGroups++] = Long.toString(r2.longValue(), 10);
            tmp = q2;
            if ((int)signum.get(tmp) == 1) break;
        }

        // Put sign (if any) and first digit group into result buffer
        StringBuilder buf = new StringBuilder(numGroups*digitsPerLong[10]+1);
        //System.out.println(digitGroup[numGroups-1]);//buf.append(digitGroup[numGroups-1]);

        // Append remaining digit groups padded with leading zeros
        for (int i=numGroups-2; i >= 0; i--) {
            // Prepend (any) leading zeros for this digit group
            int numLeadingZeros = digitsPerLong[10]-digitGroup[i].length();
            if (numLeadingZeros != 0) {
                System.out.println(zeros[numLeadingZeros]);//buf.append(zeros[numLeadingZeros]);
            }
            System.out.println(digitGroup[i]);//buf.append(digitGroup[i]);
        }
        buf.toString();


        for (String str : digitGroup) System.out.println(str);

    }
}
