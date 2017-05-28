package brian.utils.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.*;

/**
 * Created by brian on 3/13/17.
 */
public class StreamList<T> extends ArrayList<T>{
    public StreamList(Collection<? extends T> collection) {
        super(collection);
    }

    public StreamList(Stream<T> stream) {
        stream.forEach(super::add);
    }

    public StreamList<T> filter(Predicate<? super T> predicate) {
        return new StreamList<T>(stream().filter(predicate));
    }

    public <R> StreamList<R> map(Function<? super T, ? extends R> mapper) {
        return new StreamList<R>(stream().map(mapper));
    }

    public IntList mapToInt(ToIntFunction<? super T> mapper) {
        return new IntList(stream().mapToInt(mapper));
    }

    public DoubleList mapToDouble(ToDoubleFunction<? super T> mapper) {
        return new DoubleList(stream().mapToDouble(mapper));
    }

    public <R> StreamList<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return new StreamList(stream().flatMap(Stream::of));
    }

    public IntList flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return new IntList(stream().flatMapToInt(mapper));
    }

    public DoubleList flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return new DoubleList(stream().flatMapToDouble(mapper));
    }

    public StreamList<T> distinct() {
        return new StreamList<T>(stream().distinct());
    }

    public StreamList<T> sorted() {
        return new StreamList<T>(stream().sorted());
    }

    public StreamList<T> sorted(Comparator<? super T> comparator) {
        return new StreamList<T>(stream().sorted(comparator));
    }

    public StreamList<T> peek(Consumer<? super T> action) {
        return new StreamList<T>(stream().peek(action));
    }

    public StreamList<T> limit(long maxSize) {
        return new StreamList<T>(stream().limit(maxSize));
    }

    public StreamList<T> skip(long n) {
        return new StreamList<T>(stream().skip(n));
    }

    public void forEachOrdered(Consumer<? super T> action) {
        stream().forEachOrdered(action);
    }

    public <A> A[] toArray(IntFunction<A[]> generator) {
        return stream().toArray(generator);
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return stream().reduce(identity, accumulator);
    }

    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return stream().reduce(accumulator);
    }

    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return stream().reduce(identity, accumulator, combiner);
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return stream().collect(supplier, accumulator, combiner);
    }

    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return stream().collect(collector);
    }

    public Optional<T> min(Comparator<? super T> comparator) {
        return stream().min(comparator);
    }

    public Optional<T> max(Comparator<? super T> comparator) {
        return stream().max(comparator);
    }

    public long count() {
        return super.size();
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        return stream().anyMatch(predicate);
    }

    public boolean allMatch(Predicate<? super T> predicate) {
        return stream().allMatch(predicate);
    }

    public boolean noneMatch(Predicate<? super T> predicate) {
        return stream().noneMatch(predicate);
    }

    public Optional<T> findFirst() {
        return stream().findFirst();
    }

    public Optional<T> findAny() {
        return stream().findAny();
    }

    public boolean isParallel() {
        return false;
    }

    public StreamList<T> sequential() {
        return new StreamList<T>(stream().sequential());
    }

    public PStreamList<T> parallel() {
        return new PStreamList<T>(parallelStream());
    }

    public StreamList<T> unordered() {
        return new StreamList<T>(stream().unordered());
    }
}
