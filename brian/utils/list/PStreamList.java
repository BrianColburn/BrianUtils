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
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by brian on 3/13/17.
 */
public class PStreamList<T> extends ArrayList<T> {
    public PStreamList(Collection<? extends T> collection) {
        super(collection);
    }

    public PStreamList(Stream<T> stream) {
        stream.forEach(super::add);
    }

    public PStreamList<T> filter(Predicate<? super T> predicate) {
        return new PStreamList<T>(parallelStream().filter(predicate));
    }

    public <R> PStreamList<R> map(Function<? super T, ? extends R> mapper) {
        return new PStreamList<R>(parallelStream().map(mapper));
    }

    public IntList mapToInt(ToIntFunction<? super T> mapper) {
        return new IntList(parallelStream().mapToInt(mapper));
    }

    public DoubleList mapToDouble(ToDoubleFunction<? super T> mapper) {
        return new DoubleList(parallelStream().mapToDouble(mapper));
    }

    public <R> PStreamList<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return new PStreamList<R>(parallelStream().flatMap(mapper));
    }

    public IntList flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return new IntList(parallelStream().flatMapToInt(mapper));
    }

    public DoubleList flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return new DoubleList(parallelStream().flatMapToDouble(mapper));
    }

    public PStreamList<T> distinct() {
        return new PStreamList<T>(parallelStream().distinct());
    }

    public PStreamList<T> sorted() {
        return new PStreamList<T>(parallelStream().sorted());
    }

    public PStreamList<T> sorted(Comparator<? super T> comparator) {
        return new PStreamList<T>(parallelStream().sorted(comparator));
    }

    public PStreamList<T> peek(Consumer<? super T> action) {
        return new PStreamList<T>(parallelStream().peek(action));
    }

    public PStreamList<T> limit(long maxSize) {
        return new PStreamList<T>(parallelStream().limit(maxSize));
    }

    public PStreamList<T> skip(long n) {
        return new PStreamList<T>(parallelStream().skip(n));
    }

    public void forEachOrdered(Consumer<? super T> action) {
        parallelStream().forEachOrdered(action);
    }

    public <A> A[] toArray(IntFunction<A[]> generator) {
        return parallelStream().toArray(generator);
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return parallelStream().reduce(identity, accumulator);
    }

    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return parallelStream().reduce(accumulator);
    }

    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return parallelStream().reduce(identity, accumulator, combiner);
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return parallelStream().collect(supplier, accumulator, combiner);
    }

    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return parallelStream().collect(collector);
    }

    public Optional<T> min(Comparator<? super T> comparator) {
        return parallelStream().min(comparator);
    }

    public Optional<T> max(Comparator<? super T> comparator) {
        return parallelStream().max(comparator);
    }

    public long count() {
        return super.size();
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        return parallelStream().anyMatch(predicate);
    }

    public boolean allMatch(Predicate<? super T> predicate) {
        return parallelStream().allMatch(predicate);
    }

    public boolean noneMatch(Predicate<? super T> predicate) {
        return parallelStream().noneMatch(predicate);
    }

    public Optional<T> findFirst() {
        return parallelStream().findFirst();
    }

    public Optional<T> findAny() {
        return parallelStream().findAny();
    }

    public boolean isParallel() {
        return true;
    }

    public PStreamList<T> sequential() {
        return new PStreamList<T>(parallelStream().sequential());
    }

    public PStreamList<T> unordered() {
        return new PStreamList<T>(parallelStream().unordered());
    }
}