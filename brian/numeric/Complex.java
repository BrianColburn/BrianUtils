package brian.numeric;

public final class Complex extends Number implements Comparable<Complex>{
    private Double[] value = new Double[2];

    public Complex(Double real, Double imag) {
        this.value = new Double[] {real, imag};
    }

    public Complex(String s) {
        this.value = new Double[] {new Double(s.split(" ")[0]), new Double(s.split(" ")[1])};
    }

    public Double real() {
        return value[0];
    }

    public Double imag() {
        return value[1];
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (!real().equals(0)) result.append(real());
        if (imag() >= 0) result.append("+"+imag()+"I");
        else result.append(imag()+"I");
        return result.toString();
    }

    public static Complex sum(Complex c1, Complex c2) {
        return new Complex(c1.real() + c2.real(), c1.imag() + c2.imag());
    }

    public static Complex sum(Number n, Complex c) {
        return new Complex(c.real() + n.doubleValue(), c.imag());
    }

    public static Complex sum(Complex c, Number n) {
        return new Complex(c.real() + n.doubleValue(), c.imag());
    }

    public static Complex sum(Number n1, Number n2) {
        return new Complex(n1.doubleValue() + n2.doubleValue(), 0.);
    }

    public static Double norm(Complex c) {
        return Math.sqrt(Math.pow(c.real(), 2.) + Math.pow(c.imag(), 2.));
    }

    /**
     * Returns the value of the specified number as an {@code int},
     * which may involve rounding or truncation.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code int}.
     */
    @Override
    public int intValue() {
        return real().intValue();
    }

    /**
     * Returns the value of the specified number as a {@code long},
     * which may involve rounding or truncation.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code long}.
     */
    @Override
    public long longValue() {
        return real().longValue();
    }

    /**
     * Returns the value of the specified number as a {@code float},
     * which may involve rounding.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code float}.
     */
    @Override
    public float floatValue() {
        return real().floatValue();
    }

    /**
     * Returns the value of the specified number as a {@code double},
     * which may involve rounding.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code double}.
     */
    @Override
    public double doubleValue() {
        return real();
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     *
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Complex o) {
        return compare(new Complex(value[0], value[1]), o);
    }

    public static int compare(Complex c1, Complex c2) {
        return Double.compare(Math.sqrt(c1.real()*c1.real() + c1.imag()*c1.imag()), Math.sqrt(c2.real()*c2.real() + c2.imag()*c2.imag()));
    }
}
