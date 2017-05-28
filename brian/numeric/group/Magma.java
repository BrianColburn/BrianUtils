package brian.numeric.group;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public interface Magma<G, T> {
    T closedOperation(T a, T b);
}
