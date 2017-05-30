package brian.functional;

import java.util.function.Supplier;

public interface InfIterator<T> extends java.util.Iterator<T>, Supplier<T> {
    default boolean hasNext() {
        return true;
    }

    default T get() {
        return next();
    }
}
