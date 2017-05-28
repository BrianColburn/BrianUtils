package brian;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brian on 3/11/17.
 */
// Credit to Petr Pudlák
// Based on https://en.wikipedia.org/wiki/Steinhaus%E2%80%93Johnson%E2%80%93Trotter_algorithm#Even.27s_speedup
public  class DoublePermIterator implements Iterator<List<Double>> {
    private List<Double> next = null;

    private final int n;
    private List<Double> perm;
    private List<Double> dirs;

    public DoublePermIterator(int size) {
        n = size;
        if (n <= 0) {
            perm = (dirs = null);
        } else {
            perm = new ArrayList<>(n);
            dirs = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                perm.add((double) i);
                dirs.add(-1.);
            }
            dirs.set(0, 1.);
        }

        next = perm;
    }

    @Override
    public List<Double> next() {
        List<Double> r = makeNext();
        next = null;
        return r;
    }

    @Override
    public boolean hasNext() {
        return (makeNext() != null);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private List<Double> makeNext() {
        if (next != null)
            return next;
        if (perm == null)
            return null;

        // find the largest element with != 0 direction
        double i = -1., e = -1.;
        for (int j = 0; j < n; j++)
            if ((dirs.get(j) != 0) && (perm.get(j) > e)) {
                e = perm.get(j);
                i = (double) j;
            }

        if (i == -1) // no such element -> no more premutations
            return (next = (perm = (dirs = null))); // no more permutations

        // swap with the element in its direction
        double k = i + dirs.get((int) i);
        swap(i, k, dirs);
        swap(i, k, perm);
        // if it's at the start/end or the next element in the direction
        // is greater, reset its direction.
        if ((k == 0) || (k == n - 1) || (perm.get((int) (k + dirs.get((int) k))) > e))
            dirs.set((int) k, 0.);

        // set directions to all greater elements
        for (int j = 0; j < n; j++)
            if (perm.get(j) > e)
                dirs.set(j, (j < k) ? +1. : -1.);

        return (next = perm);
    }

    protected void swap(double i, double j, List<Double> arr) {
        double v = arr.get((int) i);
        arr.set((int)i, arr.get((int) j));
        arr.set((int) j, v);
    }
}