package brian.numeric.group;

/**
 * An abelian group is a set, A, together with an operation • that combines any two elements a and b to form another
 * element denoted a • b. The symbol • is a general placeholder for a concretely given operation.
 * To qualify as an abelian group, the set and operation, (A, •), must satisfy five requirements known as the abelian group axioms:
 *
 * Closure
 *     For all a, b in A, the result of the operation a • b is also in A.
 *
 * Associativity
 *     For all a, b and c in A, the equation (a • b) • c = a • (b • c) holds.
 *
 * Identity element
 *     There exists an element e in A, such that for all elements a in A, the equation e • a = a • e = a holds.
 *
 * Inverse element
 *     For each a in A, there exists an element b in A such that a • b = b • a = e, where e is the identity element.
 *
 * Commutativity
 *     For all a, b in A, a • b = b • a.
 *
 * A group in which the group operation is not commutative is called a "non-abelian group" or "non-commutative group".
 */
public interface AbelianGroup<G, T> extends Group<G, T>, Quasigroup<G, T>, Magma<G, T>, Category<G, T>, Semigroupoid<G, T> {

}
