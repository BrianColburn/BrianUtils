package brian.functional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Colburn2013 on 5/30/2017.
 */
public class Functions {

    // ---------- Memoization Methods ---------- //
    // memoize : X -> X
    // Memoize should function as if it is the identity function

    private static ConcurrentMap<Object, ConcurrentMap> maps = new ConcurrentHashMap<>();

    public static <T,R> Function<T,R> memoize(RecursiveFunction<T,R> function) {
        function.function = memoize(function.function);
        return function;
    }

    public static <T,R> Function<T,R> memoize(Function<T,R> function) {
        maps.put(function, new ConcurrentHashMap());
        return t -> {
            if (maps.get(function).containsKey(t))
                return (R) maps.get(function).get(t);
            else {
                R r = function.apply(t);
                maps.get(function).put(t,r);
                return r;
            }
        };
    }

    public static <T,U,R> BiFunction<T,U,R> memoize(BiFunction<T,U,R> function) {
        maps.put(function, new ConcurrentHashMap());
        return (t, u) -> {
            TwoTuple<T,U> tuple = new TwoTuple<>(t, u);
            if (maps.get(function).containsKey(tuple))
                return (R) maps.get(function).get(tuple);
            else {
                R r = function.apply(t,u);
                maps.get(function).put(tuple,r);
                return r;
            }
        };
    }

    public static <T> Predicate<T> memoize(Predicate<T> predicate) {
        maps.put(predicate, new ConcurrentHashMap());
        return t -> {
            if (maps.get(predicate).containsKey(t))
                return (Boolean) maps.get(predicate).get(t);
            else {
                Boolean r = predicate.test(t);
                maps.get(predicate).put(t,r);
                return r;
            }
        };
    }



    // ---------- Misc Methods ---------- //
    // curry : (T × U -> R) -> (T -> U -> R)
    // uncurry : (T -> U -> R) -> (T × U -> R)
    // uncurry(curry(f)) == f
    // curry(uncurry(f)) == f

    public static <T,U,R> Function<T, Function<U, R>> curry(BiFunction<T,U,R> biFunction) {
        return t -> u -> biFunction.apply(t, u);
    }

    public static <T,U,R> BiFunction<T,U,R> uncurry(Function<T, Function<U, R>> function) {
        return (t, u) -> function.apply(t).apply(u);
    }



    // ---------- Map / Fold Methods for various classes ---------- //
    // map : (T -> R) × (Collection | T) -> Collection | R
    // foldr : (T × R -> R) × R × (Collection | T) -> R
    // foldl : (R × T -> R) × R × (Collection | T) -> R

    // ----- Iterator
    public static <T,R> Iterator<R> map(Function<T,R> function, Iterator<T> iterator) {
        return new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public R next() {
                return function.apply(iterator.next());
            }
        };
    }

    public static <T,R> R foldr(BiFunction<T,R,R> function, R init, Iterator<T> iterator) {
        R accumulator = init;
        while (iterator.hasNext()) {
            accumulator = function.apply(iterator.next(), accumulator);
        }
        return accumulator;
    }

    // ----- List
    public static <T,R> List<R> map(Function<T,R> function, List<T> list) {
        List<R> retList;
        try {
            retList = list.getClass().newInstance();
        } catch (Exception e) {
            retList = new ArrayList<>(list.size());
        }
        for (T t : list) {
            retList.add(function.apply(t));
        }
        return retList;
    }

    public static <T,R> R foldr(BiFunction<T,R,R> function, R init, List<T> list) {
        R accumulator = init;
        for (int i = 0; i < list.size(); i++) {
            accumulator = function.apply(list.get(i), accumulator);
        }
        return accumulator;
    }

    public static <T,R> R foldl(BiFunction<R,T,R> function, R init, List<T> list) {
        R accumulator = init;
        for (int i = list.size()-1; i >= 0; i--) {
            accumulator = function.apply(accumulator, list.get(i));
        }
        return accumulator;
    }

    // ----- Array
    public static <T,R> R[] map(Function<T,R> function, T[] array) {
        R[] retArray = (R[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            retArray[i] = function.apply(array[i]);
        }
        return retArray;
    }

    public static <T,R> R foldr(BiFunction<T,R,R> function, R init, T[] array) {
        R accumulator = init;
        for (int i = 0; i < array.length; i++) {
            accumulator = function.apply(array[i], accumulator);
        }
        return accumulator;
    }

    public static <T,R> R foldl(BiFunction<R,T,R> function, R init, T[] array) {
        R accumulator = init;
        for (int i = array.length-1; i >= 0; i--) {
            accumulator = function.apply(accumulator, array[i]);
        }
        return accumulator;
    }
}
