package brian.utils.list;

import brian.numeric.Complex;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Colburn2013 on 3/12/2017.
 */
public class ComplexList extends AbstractNumberList<Stream<Complex>, ComplexList, Complex> {

    public ComplexList() {}

    public ComplexList(Complex... nums) {
        addAll(Arrays.asList(nums));
    }

    public ComplexList(Collection<? extends Complex>... lists) {
        for (Collection<? extends Complex> list : lists)
            addAll(list);
    }

    public ComplexList(Complex[]... arrays) {
        for (Complex[] array : arrays)
            this.addAll(Arrays.asList(array));
    }

    public ComplexList(Stream<Complex>... streams) {
        for (Stream<Complex> stream : streams)
            stream.forEachOrdered(super::add);
    }
    @Override
    public ComplexList of(Collection<Complex> collection) {
        return new ComplexList(collection);
    }

    @Override
    public ComplexList of(Stream<Complex> stream) {
        return new ComplexList(stream);
    }

    @Override
    public List<Complex> list() {
        return subList(0,size());
    }

    @Override
    public Complex sum() {
        return stream().reduce(new Complex(0.,0.), Complex::sum);
    }

    @Override
    public ComplexList sorted() {
        return sorted(Complex::compare);
    }

    @Override
    public ComplexList sorted(Comparator<? super Complex> comparator) {
        return of(stream().sorted(comparator));
    }
}
