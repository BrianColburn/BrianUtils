package brian.utils.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Colburn2013 on 4/9/2017.
 */
public abstract class AbstractNumberList<ST, LT extends NumberList<ST, LT, T>, T extends Number> extends ArrayList<T> implements NumberList<ST, LT, T> {
    /**
     * Provide access to the super list
     *
     * @return super
     */
    @Override
    public abstract List<T> list();

    /**
     * Custom get that allows negative indices
     *
     * @param n
     *
     * @return super.get(n) if n >= 0 else super.get(super.size() - n)
     */
    @Override
    public T get(int n) {
        return n < 0
                ? list().get(size() - n)
                : list().get(n);
    }

    /**
     * Sum the elements in the list
     *
     * @return summed list
     */
    @Override
    public abstract T sum();

    /**
     * Sort a <b>copy</b> of the list <b>without</b> modifying the real list
     *
     * @return sorted list
     */
    @Override
    public abstract LT sorted();

    /**
     * Sort a <b>copy</b> of the list <b>without</b> modifying the real list
     *
     * @param comparator
     *
     * @return sorted list
     */
    @Override
    public abstract LT sorted(Comparator<? super T> comparator);

    /**
     * The average of the list
     *
     * @return (1/n) Sum[list.get(i), {i, 0, n}]
     */
    @Override
    public Double mean() {
        return sum().doubleValue()/size();
    }

    /**
     * The median of the list
     *
     * @return If the list is odd, then the middle. Else, the mean of the elements on either side.
     */
    @Override
    public Double median() {
        LT list = sorted();
        if (list.size() % 2 == 1) return list.get(list.size()/2).doubleValue();
        else return (list.get(list.size()/2 - 1).doubleValue() + list.get(list.size()/2).doubleValue()) / 2.;
    }

    /**
     * The most reoccurring element of the list
     *
     * @return the most common element
     */
    @Override
    public T mode() {
        Map<T, Integer> tally = new HashMap<>();
        forEach(n -> tally.put(n, tally.getOrDefault(n, 0) + 1));
        return tally
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();
    }

    /**
     * Partition the list in multiple lists of size <i>n</i>.
     * If <i>n</i> does not divide into the list evenly, then tack the extra elements on the end.
     * So if your list is {1, 2, 3, 4, 5, 6} then:
     * partition(2) = {{1, 2}, {3, 4}, {5, 6}}
     * partition(4) = {{1, 2, 3, 4}, {5, 6}}
     *
     * @param n
     *
     * @return partitioned list
     */
    @Override
    public List<LT> partition(int n) {
        List<LT> partitions = new ArrayList<>();
        Deque<T> nums = new ArrayDeque<>(list());

        for (int i = 0; i < size()/n; i++) {
            for (int j = 0; j < n; j++)
                partitions.add(of(subList(i*n+j, i*n+n)));
        }

        if (nums.peek() != null) partitions.add(of(nums));

        return partitions;
    }

    @Override
    public String toString() {
        return "{" + list().toString().substring(1, super.toString().length() - 1) + "}";
    }
}
