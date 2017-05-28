package brian.numeric.domain;

import brian.functional.InfIterator;

/**
 * Created by Colburn2013 on 5/25/2017.
 */
public class Natural implements NumericDomain<Long> {

    private class Iterator implements InfIterator<Long> {
        long n = 0;
        @Override
        public Long next () {
            return n++;
        }
    }

    public InfIterator<Long> iterator() {
        return new Iterator();
    }

    public static boolean contains(Number n) {
        return Countable.contains(n) || n.intValue() == 0;
    }
}
