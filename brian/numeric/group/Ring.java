package brian.numeric.group;

/**
 * http://mathworld.wolfram.com/Ring.html
 *
 * A ring in the mathematical sense is a set S together with two binary operators + and * (commonly interpreted as addition and multiplication, respectively)
 * satisfying the following conditions:
 * 1. Additive associativity: For all a,b,c in S, (a+b)+c=a+(b+c),
 * 2. Additive commutativity: For all a,b in S, a+b=b+a,
 * 3. Additive identity: There exists an element 0 in S such that for all a in S, 0+a=a+0=a,
 * 4. Additive inverse: For every a in S there exists  -a in S such that a+(-a)=(-a)+a=0,
 * 5. Left and right distributivity: For all a,b,c in S, a*(b+c)=(a*b)+(a*c) and (b+c)*a=(b*a)+(c*a),
 * 6. Multiplicative associativity: For all a,b,c in S, (a*b)*c=a*(b*c) (a ring satisfying this property is sometimes explicitly termed an associative ring).
 * Conditions 1-5 are always required. Though non-associative rings exist, virtually all texts also require condition 6
 * (Itô 1986, pp. 1369-1372; p. 418; Zwillinger 1995, pp. 141-143; Harris and Stocker 1998; Knuth 1998; Korn and Korn 2000; Bronshtein and Semendyayev 2004).
 */
public interface Ring<G, T> extends AbelianGroup<G, T>, Monoid<G, T>, Group<G, T>, Quasigroup<G, T>, Magma<G, T>, Category<G, T>, Semigroupoid<G, T> {
    T add(T a, T b);
    T multiply(T a, T b);
    T multiplicativeIdentity();
}
