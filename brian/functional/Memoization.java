package brian.functional;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Colburn2013 on 5/24/2017.
 */
public class Memoization {
    private static ConcurrentMap<Object, ConcurrentMap> maps = new ConcurrentHashMap<>();

    public static <T,R> void memoize(RecursiveFunction<T,R> function) {
        function.function = memoize(function.function);
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
}
