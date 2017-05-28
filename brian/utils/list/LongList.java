package brian.utils.list;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class LongList extends ArrayList<Long> implements NumberList<LongStream, LongList, Long> {

    public LongList() {super();}

    public <T extends Number> LongList(Collection<T>... collections) {
        Stream.of(collections)
                .forEach(collection -> collection.stream()
                        .mapToLong(Number::longValue)
                        .forEach(this::add));

        //for (Collection<? extends Long> list : lists)
        //    addAll(list);
    }

    public LongList(long[]... arrays) {
        for (long[] array : arrays)
            for (long n : array)
                add(n);
    }

    public LongList(LongStream... streams) {
        Stream.of(streams).forEach(stream -> stream.forEach(this::add));

        //for (LongStream stream : streams)
        //    stream.forEachOrdered(this::add);
    }

    @Override
    public LongList of(Collection<Long> collection) {
        return new LongList(collection);
    }

    @Override
    public LongList of(Stream<Long> stream) {
        return new LongList(stream.mapToLong(n -> n));
    }

    @Override
    public List<Long> list() {
        return subList(0, size());
    }

    @Override
    public Long get(int n) {
        return n >= 0 ? super.get(n) : super.get(size() - n);
    }

    @Override
    public Long sum() {
        return longStream().sum();
    }

    @Override
    public LongList sorted() {
        return sorted(Long::compare);
    }

    @Override
    public LongList sorted(Comparator<? super Long> comparator) {
        LongList list = of(list());
        list.sort(comparator);
        return list;
    }

    @Override
    public Double mean() {
        return longStream()
                .average()
                .getAsDouble();
    }

    @Override
    public Double median() {
        LongList list = sorted();
        if (list.size() % 2 == 1) return list.get(list.size()/2).doubleValue();
        else return (list.get(list.size()/2 - 1) + list.get(list.size()/2)) / 2.;
    }

    @Override
    public Long mode() {
        Map<Long, Integer> longTally = new HashMap<>();
        longStream().forEach(n -> longTally.put(n, longTally.getOrDefault(n, 0) + 1));
        return longTally
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();
    }

    @Override
    public List<LongList> partition(int n) {
        List<LongList> partitions = new ArrayList<>();
        Deque<Long> longs = new ArrayDeque<>(list());

        for (int i = 0; i < super.size()/n; i++) {
            partitions.add(new LongList());
            for (int j = 0; j < n; j++)
                partitions.get(i).add(longs.pop());
        }

        if (longs.peek() != null) partitions.add(new LongList(longs));

        return partitions;
    }

    public String toString() {
        return "{" + super.toString().substring(1, super.toString().length() - 1) + "}";
    }

    public StreamList<Long> boxed() {
        return new StreamList<>(stream());
    }
}
