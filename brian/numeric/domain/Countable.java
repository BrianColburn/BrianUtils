package brian.numeric.domain;

import brian.functional.InfIterator;

/**
 * Created by Colburn2013 on 5/25/2017.
 */
public class Countable implements NumericDomain<Long> {

    private class Iterator implements InfIterator<Long> {
        long n = 1;
        @Override
        public Long next() {
            return n++;
        }
    }

    public InfIterator<Long> iterator() {
        return new Iterator();
    }

    public static boolean contains(Number n) {
        return n.intValue() == n.doubleValue() && n.intValue() > 0;
    }
}
