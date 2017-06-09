import brian.Prime;
import brian.functional.InfList;
import brian.numeric.Complex;
import brian.numeric.IntegerRing;
import brian.functional.InfIterator;
import brian.functional.IterTools;
import brian.numeric.NumberUtils;
import brian.utils.list.IndexedLinkedList;
import brian.utils.list.IntList;
//import brian.utils.list.StreamList;
import brian.utils.list.StreamList;
import brian.utils.matrix.IntMatrix;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Colburn2013 on 3/8/2017.
 */
public class test {
    public static void main(String... args) {
        IntMatrix matrix = new IntMatrix(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

        System.out.println("Matrix:\n"+matrix+'\n');
        System.out.println("Transposed Matrix:\n"+matrix.transpose()+'\n');
        System.out.println("Sum of Rows: "+matrix.sumRows());
        System.out.println("Sum of Columns"+matrix.sumColumns());
        System.out.println("Mapped Matrix:\n"+matrix.map(n -> n*n));
        IntMatrix overlayMatrix = new IntMatrix(new int[] {4, 3, 2, 1});
        System.out.println("Overlay Matrix:\n"+matrix.overlay(overlayMatrix, 1));
        System.out.println("Final Matrix:\n"+matrix+'\n');
        System.out.println(new IntMatrix(new int[][] {{1,2},{3,4},{5,6}}).transpose().transpose());

        System.out.println(new Prime().primeList(10));
        System.out.println(new Prime().primeN(7));
        Iterator<Long> primes = new Prime().primeIterator();
        for (int i = 0; i < 10; i++) {
            System.out.print(primes.next() + " ");
        }
        System.out.println();

        IntList intList = new IntList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0));
        System.out.println("List: "+intList);
        System.out.println(intList.sum());
        System.out.println(intList.reduce(0, Integer::sum));
        System.out.println(intList.mean());
        System.out.println(intList.median());
        System.out.println(intList.mode());
        System.out.println(intList.median());
        System.out.println(intList.map(n -> n*n));
        System.out.println(intList.filter(new Prime().primeQ::test));
        System.out.println(new IntList(intList.filter(n -> Math.sqrt(n) == (int) Math.sqrt(n)), intList.filter(new Prime().primeQ::test)));
        System.out.println(new HashSet<>(intList).contains(intList.get(4)));
        System.out.println("Final List: "+intList);

        System.out.println(new Complex(1.,2.));
        System.out.println(new Complex("5. -7."));

        StreamList<Integer> streamList = new StreamList<>(intList.list());
        System.out.println(streamList);
        System.out.println(streamList.filter(new Prime().primeQ::test));
        streamList.forEach(System.out::print);
        System.out.println();
        System.out.println(streamList.get(5));
        System.out.println(streamList.mapToInt(n -> n));

        System.out.println(NumberUtils.factorial(6));

        IndexedLinkedList<Integer> indexedLinkedList = new IndexedLinkedList<>(intList);
        System.out.println(indexedLinkedList.size());
        System.out.println(indexedLinkedList.get(2));
        System.out.println(indexedLinkedList.get(indexedLinkedList.size()-2));

        InfIterator infIterator = IterTools.count(1L);
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" "+infIterator.next());
        }

        infIterator = IterTools.repeat("Hello, World!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" "+infIterator.next());
        }

        infIterator = IterTools.cycle(new IntList(new int[]{1,2,3}));
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" "+infIterator.next());
        }

        infIterator = IterTools.accumulate(IterTools.count(1L));
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" "+infIterator.next());
        }

        infIterator = IterTools.accumulate(IterTools.count(1L), (a, b) -> a * b);
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" "+infIterator.next());
        }

        Iterator iterator  = IntStream.range(0,10).iterator();
        Iterator iterator2 = IntStream.range(10,20).iterator();
        Iterator chained   = IterTools.chain(iterator, iterator2);
        chained.forEachRemaining(System.out::print);
        System.out.println();
        IterTools.compress(IntStream.range(0,10).iterator(), Arrays.asList(0,1,0,1,0,1,0,1,0,1))
                 .forEachRemaining(System.out::print);
        System.out.println();

        InfList<Long> primeList = new InfList<>(new Prime().primeIterator());
        for (Integer i = 0; i < 10; i++) {
            System.out.println(i+" "+primeList.get(i));
        }
        //System.out.println(primeList.get(10000));

        IntegerRing n = new IntegerRing(5);
        System.out.println(n.add(2,3));

        System.out.println("\nEND");

        /*List<Number> list1 = new ArrayList<>();
        list1.add(1);
        System.out.println(list1);
        List<Number> list2 = list1;
        list2.add(2);
        System.out.println(list1+"\n"+list2);
        List<Number> list3 = new ArrayList<>(list1);
        list3.add(3);
        System.out.println(list1+"\n"+list2+"\n"+list3);*/
    }
}
