package brian.functional;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Supplier;

/**
 * InfList is basically an indexed infinite iterator.
 *
 * The idea of InfList is to provide a list class can hold more than an array (maxint).
 * Originally this was just a fancy linked list, but that's pretty terrible
 *     access time for something larger than maxint. It turns out that ArrayList, HashMap,
 *     and HashSet, are all storing things in arrays, so that pretty much ruled out the
 *     standard library for this.
 * I brought this problem to my computer science teacher, and he had the idea of indexing
 *     via a tree. So 'get(100)' would go from a node with branches [0..9], to the first node
 *     with branches [0..9], to the zeroth node twice. Or visually,
 *
 *     0       /--> 0 --> 0
 *     1 ----/     ...   ...
 *    ...           9     9
 *     9
 *
 * This is a significant increase in access speed, from O(n) where n is the length of the list,
 *     to O(n) where n is the number of digits in the index, but has one draw back.
 *     If the node that is being accessed hasn't been generated yet, then it'll slow down
 *     to linear access time as it generates every value up to the index.
 *
 */
public class InfList<T> {
    // The iterator is where the values are generated from
    private Supplier<T> supplier;

    // This is how we keep track of how many values we've generated
    // It has to be a BigInt because everything else will overflow
    // Technically BigInt overflows as well, but if you have a list that big
    //     you should probably reconsider your choice of libraries
    // Also, the GC crashes before 'size' can get close to maxint
    private BigInteger size = BigInteger.ZERO;
    private Node<T> list = new Node<>(null,10);

    public InfList(Supplier<T> supplier) {
        this.supplier    = supplier;
        list.children[0] = new Node<>(this.supplier.get(),10);
    }

    public T get(Number index) {
        String indexString = index.toString();
        if (new BigInteger(indexString).compareTo(size) > -1) generate(indexString);
        char[] indices = indexString.toCharArray();
        Node<T> currentNode = list;
        for (int i : indices) { // This loop sort of recursively looks up an index.
            currentNode = currentNode.children[i-48];
        }
        return currentNode.data;
    }

    private void generate(String str) {
        BigInteger index = new BigInteger(str);
        while (index.compareTo(size) > -1) {
            // interestingly enough, when the GC crashes it's during the toString call...
            char[] indices = size.add(BigInteger.ONE).toString().toCharArray();
            Node<T> currentNode = list;
            for (int i = 0; i < indices.length - 1; i++) {
                currentNode = currentNode.children[indices[i]-48];
            }
            currentNode.children[indices[indices.length-1]-48] = new Node<>(supplier.get(), 10);
            size = size.add(BigInteger.ONE);
        }
    }

    private class Node<NT> {
        NT data;
        Node<NT>[] children;

        Node(NT data, int size) {
            this.data = data;
            children  = new Node[size];
        }

        public String toString() {
            return data + (children[0] == null ? "" : " : " + Arrays.toString(children));
        }
    }
}
