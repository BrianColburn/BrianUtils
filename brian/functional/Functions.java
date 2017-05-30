package brian.functional;

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


    // ---------- Curry / Uncurry Methods ---------- //
    public static <T,U,R> Function<T, Function<U, R>> curry(BiFunction<T,U,R> biFunction) {
        return t -> u -> biFunction.apply(t, u);
    }

    public static <T,U,R> BiFunction<T,U,R> uncurry(Function<T, Function<U, R>> function) {
        return (t, u) -> function.apply(t).apply(u);
    }
}
