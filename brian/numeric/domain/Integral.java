package brian.numeric.domain;

import brian.functional.InfIterator;

/**
 * Created by Colburn2013 on 5/25/2017.
 */
public class Integral implements NumericDomain<Long> {

    private class Iterator implements InfIterator<Long> {
        long n = 0;
        @Override
        public Long next () {
            long r = n;
            n = n <= 0 ? -n+1 : -n;
            return r;
        }
    }

    public InfIterator<Long> iterator() {
        return new Iterator();
    }

    public static boolean contains(Number n) {
        return n.intValue() == n.doubleValue();
    }
}
