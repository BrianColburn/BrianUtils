package brian.numeric.group;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public interface Group<G, T> extends Quasigroup<G, T>,
        Magma<G, T>,
        Category<G, T>,
        Semigroupoid<G, T> {
}
