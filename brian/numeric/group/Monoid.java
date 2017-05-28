package brian.numeric.group;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public interface Monoid<G, T> extends Magma<G, T>,
        Category<G, T>,
        Semigroupoid<G, T> {
}
