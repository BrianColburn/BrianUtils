package brian.numeric.group;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public interface Loop<G, T> extends Quasigroup<G, T>, Magma<G, T> {
    T identity();
}
