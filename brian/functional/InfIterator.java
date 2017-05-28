package brian.functional;

public interface InfIterator<T> extends java.util.Iterator<T> {
    default boolean hasNext() {
        return true;
    }
}
