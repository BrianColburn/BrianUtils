package brian.functional;

import brian.numeric.NumberUtils;

import java.util.*;
import java.util.function.BinaryOperator;

public class IterTools {
    public static InfIterator<Long> count(Long init) {
        return count(init, 1L);
    }

    public static InfIterator<Long> count(Long init, Long step) {
        return new InfIterator<Long>() {
            long val = init;
            @Override
            public Long next() {
                long ret = val;
                val += step;
                return ret;
            }
        };
    }

    public static <T> InfIterator<T> cycle(List<T> list) {
        return new InfIterator<T>() {
            int length = list.size();
            int pos    = 0;
            @Override
            public T next() {
                if (pos%length == 0) pos = 0;
                return list.get(pos++%length);
            }
        };
    }

    public static <T> InfIterator<T> repeat(T elem) {
        return () -> elem;
    }

    public static <T> Iterator<T> repeat(T elem, Long n) {
        return new Iterator<T>() {
            long size = 0;
            public boolean hasNext() {
                return size < n;
            }
            public T next() {
                if (hasNext()) {
                    size++;
                    return elem;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }



    public static <T extends Number> InfIterator<T> accumulate(InfIterator<T> iterator) {
        return accumulate(iterator, (a, b) -> (T) NumberUtils.add(a,b));
    }

    public static <T> InfIterator<T> accumulate(InfIterator<T> iterator, BinaryOperator<T> function) {
        return new InfIterator<T>() {
            T acc = iterator.next();

            @Override
            public T next() {
                T ret = acc;
                acc = function.apply(acc, iterator.next());
                return ret;
            }
        };
    }

    public static <T extends Number> Iterator<T> accumulate(Iterator<T> iterator) {
        return accumulate(iterator, (a, b) -> (T) NumberUtils.add(a,b));
    }

    public static <T> Iterator<T> accumulate(Iterator<T> iterator, BinaryOperator<T> function) {
        return new Iterator<T>() {
            T acc = iterator.next();
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                T ret = acc;
                acc = function.apply(acc, iterator.next());
                return ret;
            }
        };
    }

    public static <T> Iterator<T> chain(Iterator<T> iterator1, Iterator<T> iterator2) {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator1.hasNext() || iterator2.hasNext();
            }

            @Override
            public T next() {
                return iterator1.hasNext() ? iterator1.next() : iterator2.next();
            }
        };
    }

    // This should be rewritten so that it's lazy.
    public static <T> Iterator<T> compress(Iterator<T> iterator, Iterable<Number> nums) {
        List<T> filtered = new ArrayList<>();
        Iterator<Number> filters = nums.iterator();
        iterator.forEachRemaining(e -> {
            if (filters.next().equals(1)) filtered.add(e);
        });
        return filtered.iterator();
    }
}
