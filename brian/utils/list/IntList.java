package brian.utils.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class IntList extends ArrayList<Integer> implements NumberList<IntStream, IntList, Integer> {

    public IntList() {super();}

    public <T extends Number> IntList(Collection<T>... collections) {
        Stream.of(collections)
                .forEach(collection -> collection.stream()
                        .mapToInt(Number::intValue)
                        .forEach(this::add));

        //for (Collection<? extends Integer> list : lists)
        //    addAll(list);
    }

    public IntList(int[]... arrays) {
        for (int[] array : arrays)
            for (int n : array)
                add(n);
    }

    public IntList(IntStream... streams) {
        Stream.of(streams).forEach(stream -> stream.forEach(this::add));

        //for (IntStream stream : streams)
        //    stream.forEachOrdered(this::add);
    }

    @Override
    public IntList of(Collection<Integer> collection) {
        return new IntList(collection);
    }

    @Override
    public IntList of(Stream<Integer> stream) {
        return new IntList(stream.mapToInt(n -> n));
    }

    @Override
    public List<Integer> list() {
        return subList(0, size());
    }

    @Override
    public Integer get(int n) {
        return n >= 0 ? super.get(n) : super.get(size() - n);
    }

    @Override
    public Integer sum() {
        return intStream().sum();
    }

    @Override
    public IntList sorted() {
        return sorted(Integer::compare);
    }

    @Override
    public IntList sorted(Comparator<? super Integer> comparator) {
        IntList list = of(list());
        list.sort(comparator);
        return list;
    }

    @Override
    public Double mean() {
        return intStream()
                .average()
                .getAsDouble();
    }

    @Override
    public Double median() {
        IntList list = sorted();
        if (list.size() % 2 == 1) return list.get(list.size()/2).doubleValue();
        else return (list.get(list.size()/2 - 1) + list.get(list.size()/2)) / 2.;
    }

    @Override
    public Integer mode() {
        Map<Integer, Integer> intTally = new HashMap<>();
        intStream().forEach(n -> intTally.put(n, intTally.getOrDefault(n, 0) + 1));
        return intTally
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();
    }

    @Override
    public List<IntList> partition(int n) {
        List<IntList> partitions = new ArrayList<>();
        Deque<Integer> ints = new ArrayDeque<>(list());

        for (int i = 0; i < super.size()/n; i++) {
            partitions.add(new IntList());
            for (int j = 0; j < n; j++)
                partitions.get(i).add(ints.pop());
        }

        if (ints.peek() != null) partitions.add(new IntList(ints));

        return partitions;
    }

    public String toString() {
        return "{" + super.toString().substring(1, super.toString().length() - 1) + "}";
    }

    public StreamList<Integer> boxed() {
        return new StreamList<>(stream());
    }
}
