package brian.numeric.group;

/**
 * http://mathworld.wolfram.com/Field.html
 *
 * A field is any set of elements that satisfies the field axioms for both addition and multiplication and is a commutative division algebra.
 *
 * The field axioms are generally written in additive and multiplicative pairs.
 *     name            addition           multiplication
 * associativity    (a+b)+c=a+(b+c)        (ab)c=a(bc)
 * commutativity        a+b=b+a               ab=ba
 * distributivity    a(b+c)=ab+ac         (a+b)c=ac+bc
 * identity            a+0=a=0+a            a·1=a=1·a
 * inverses         a+(-a)=0=(-a)+a     aa^(-1)=1=a^(-1)a if a!=0
 */
public interface Field<G, T> extends Ring<G, T>, AbelianGroup<G,T>, Monoid<G,T>, Group<G,T>, Quasigroup<G,T>, Magma<G,T>, Category<G,T>, Semigroupoid<G,T> {
    /**
     * The multiplicative identity I
     * Must satisfy A.multiply(multIdentity()) == multIdentity().multiply(A) == A
     * @return I
     */
    T multIdentity();
    T multiplicativeInverse();
}
