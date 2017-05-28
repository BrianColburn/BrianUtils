package brian.utils.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface NumberList<ST, LT extends NumberList<ST, LT, T>, T extends Number> extends List<T> {

    /**
     * The "of(...)" methods allow you to instantiate parametrically polymorphic lists
     */
    LT of(Collection<T> collection);
    LT of(Stream<T> stream);

    /**
     * Provide access to the underlying list
     * @return super
     */
    List<T> list();

    /**
     * Custom get that allows negative indices
     * @param n
     * @return super.get(n) if n >= 0 else super.get(super.size() - n)
     */
    T get(int n);

    /**
     * Sum the elements in the list
     * @return summed list
     */
    T sum();

    /**
     * Sort a <b>copy</b> of the list <b>without</b> modifying the real list
     * @return sorted list
     */
    LT sorted();

    /**
     * Sort a <b>copy</b> of the list <b>without</b> modifying the real list
     * @return sorted list
     */
    LT sorted(Comparator<? super T> comparator);

    /**
     * The average of the list
     * @return (1/n) Sum[list.get(i), {i, 0, n}]
     */
    Double mean();

    /**
     * The median of the list
     * @return If the list is odd, then the middle. Else, the mean of the elements on either side.
     */
    Double median();

    /**
     * The most reoccurring element of the list
     * @return the most common element
     */
    T mode();

    /**
     * Partition the list in multiple lists of size <i>n</i>.
     * If <i>n</i> does not divide into the list evenly, then tack the extra elements on the end.
     * So if your list is {1, 2, 3, 4, 5, 6} then:
     * partition(2) = {{1, 2}, {3, 4}, {5, 6}}
     * partition(4) = {{1, 2, 3, 4}, {5, 6}}
     * @param n
     * @return partitioned list
     */
    List<LT> partition(int n);

    default IntStream intStream(){
        return intStream(Number::intValue);
    }

    default IntStream intStream(ToIntFunction<T> mapper){
        return stream().mapToInt(mapper);
    }

    default DoubleStream doubleStream(){
        return doubleStream(Number::doubleValue);
    }

    default DoubleStream doubleStream(ToDoubleFunction<T> mapper){
        return stream().mapToDouble(mapper);
    }

    default LongStream longStream(){
        return longStream(Number::longValue);
    }

    default LongStream longStream(ToLongFunction<T> mapper){
        return stream().mapToLong(mapper);
    }

    default LT map(UnaryOperator<T> function) {
        return of(stream().map(function));
    }

    default LT filter(Predicate<T> predicate) {
        return  of(stream().filter(predicate));
    }

    default LT distinct() {
        return of(stream().distinct());
    }

    default LT peek(Consumer<T> action) {
        return of(stream().peek(action));
    }

    default LT limit(long n) {
        return of(stream().limit(n));
    }

    default LT skip(long n) {
        return of(stream().skip(n));
    }

    default T reduce(T identity, BinaryOperator<T> f) {
        return stream().reduce(identity, f);
    }

    default Optional<T> reduce(BinaryOperator<T> f) {
        return stream().reduce(f);
    }

    default Optional<T> min(Comparator<T> comparator) {
        return stream().min(comparator);
    }

    default Optional<T> max(Comparator<T> comparator) {
        return stream().max(comparator);
    }

    default Boolean anyMatch(Predicate<T> p) {
        return stream().anyMatch(p);
    }

    default Boolean allMatch(Predicate<T> p) {
        return stream().allMatch(p);
    }

    default Boolean noneMatch(Predicate<T> p) {
        return stream().noneMatch(p);
    }

    // In addition to these methods stream like methods should be implemented if possible
}
