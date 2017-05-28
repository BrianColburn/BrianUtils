package brian.numeric.group;

/**
 * A semigroup is a set S together with a binary operation "f" (that is, a function f:S*S->S) that satisfies the associative property:
 * For all a,b,c in S, the equation f(f(a,b), c) = f(a, f(b, c)) holds.
 * More succinctly, a semigroup is an associative magma.
 */
public interface Semigroup<G, T> extends Magma<G, T>, Semigroupoid<G, T> {
}
