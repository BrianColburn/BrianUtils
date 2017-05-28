package brian.numeric.domain;

import brian.functional.InfIterator;

/**
 * Created by Colburn2013 on 5/25/2017.
 */
public class Rational implements NumericDomain<Double> {
    public class NumeratorIterator implements InfIterator<Double> {
        private boolean ascending = true;
        private double n = 0;
        private double c = 2;

        @Override
        public Double next() {
            if (n < c) {
                if (ascending) {
                    n++;
                } else {
                    if (n > 1) {
                        n--;
                    } else ascending = true;
                }
            } else {
                c+=2;
                ascending = false;
                n--;
            }
            return n;
        }
    }

    public class DenominatorIterator implements InfIterator<Double> {
        private boolean ascending = true;
        private double n = 1;
        private double c = 1;

        @Override
        public Double next() {
            if (n < c) {
                if (ascending) {
                    n++;
                } else {
                    if (n > 1) {
                        n--;
                    } else ascending = true;
                }
            } else {
                c+=2;
                ascending = false;
                n = Math.max(n-1,1);
            }
            return n;
        }
    }

    private class Iterator implements InfIterator<Double> {
        NumeratorIterator numers = new NumeratorIterator();
        DenominatorIterator denoms = new DenominatorIterator();
        double n = 0;
        @Override
        public Double next () {
            double r = n;
            n = n > 0 ? -n : numers.next()/denoms.next();
            return r;
        }
    }

    public InfIterator<Double> iterator() {
        return new Iterator();
    }

    public static boolean contains(Number n) {
        return n.equals(n.doubleValue());
    }
}
