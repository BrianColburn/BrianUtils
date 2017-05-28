package brian.numeric.group;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public interface Category<G, T> extends Semigroupoid<G, T> {
    T identity();
}
