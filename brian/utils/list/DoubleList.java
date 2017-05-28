package brian.utils.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class DoubleList extends ArrayList<Double> implements NumberList<DoubleStream, DoubleList, Double> {

    public DoubleList() {}

    public DoubleList(double... nums) {
        for (double n : nums)
            add(n);
    }

    public DoubleList(Collection<? extends Double>... lists) {
        for (Collection<? extends Double> list : lists)
            addAll(list);
    }

    public DoubleList(double[]... arrays) {
        for (double[] array : arrays)
            for (double n : array)
                add(n);
    }

    public DoubleList(DoubleStream... streams) {
        for (DoubleStream stream : streams)
            stream.forEachOrdered(super::add);
    }

    @Override
    public DoubleList of(Collection<Double> collection) {
        return new DoubleList(collection);
    }

    @Override
    public DoubleList of(Stream<Double> stream) {
        return new DoubleList(stream.mapToDouble(n -> n));
    }

    @Override
    public List<Double> list() {
        return subList(0, size());
    }

    @Override
    public Double get(int n) {
        return n >= 0 ? super.get(n) : super.get(size() - n);
    }

    @Override
    public Double sum() {
        return doubleStream().sum();
    }

    @Override
    public DoubleList sorted() {
        return sorted(Double::compare);
    }

    @Override
    public DoubleList sorted(Comparator<? super Double> comparator) {
        DoubleList list = new DoubleList(list());
        list.sort(comparator);
        return list;
    }

    @Override
    public Double mean() {
        return doubleStream()
                .average()
                .getAsDouble();
    }

    @Override
    public Double median() {
        DoubleList list = sorted();
        if (list.size() % 2 == 1) return list.get(list.size()/2);
        else return (list.get(list.size()/2 - 1) + list.get(list.size()/2)) / 2.;
    }

    @Override
    public Double mode() {
        Map<Double, Integer> intTally = new HashMap<>();
        doubleStream().forEach(n -> intTally.put(n, intTally.getOrDefault(n, 0) + 1));
        return intTally
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();
    }

    @Override
    public List<DoubleList> partition(int n) {
        List<DoubleList> partitions = new ArrayList<>();
        Deque<Double> doubles = new ArrayDeque<>(list());

        for (int i = 0; i < super.size()/n; i++) {
            partitions.add(new DoubleList());
            for (int j = 0; j < n; j++)
                partitions.get(i).add(doubles.pop());
        }

        if (doubles.peek() != null) partitions.add(new DoubleList(doubles));

        return partitions;
    }

    public String toString() {
        return "{" + super.toString().substring(1, super.toString().length() - 1) + "}";
    }

    public StreamList<Double> boxed() {
        return new StreamList<>(stream());
    }
}
