package brian.numeric.domain;

import brian.functional.InfIterator;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Colburn2013 on 5/27/2017.
 */
public interface NumericDomain<T> {
    InfIterator<T> iterator();

    default Supplier<T> supplier() {
        return iterator()::next;
    }

    default Stream<T> stream() {
        return Stream.generate(supplier());
    }

    static boolean contains(Number n) {
        return false;
    };
}
