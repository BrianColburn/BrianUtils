package brian.numeric.group;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public interface Quasigroup<G, T>  extends Magma<G, T> {
    T inverse();
}
