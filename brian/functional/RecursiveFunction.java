package brian.functional;

import java.util.function.Function;

/**
 * Created by Colburn2013 on 5/27/2017.
 */
public class RecursiveFunction<T,R> implements Function<T,R> {
    public Function<T,R> function;

    @Override
    public R apply(T t) {
        return function.apply(t);
    }
}
