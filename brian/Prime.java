package brian;

import brian.functional.InfIterator;
import brian.functional.Memoization;
import brian.utils.list.IntList;
import brian.utils.list.LongList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.LongStream;

public class Prime {
    private static Set<Long> primes = new HashSet<>(Arrays.asList(2L, 3L, 5L, 7L, 11L));
    private LongSupplier supplier = primeSupplier();

    public Predicate<Number> primeQ = (Number num) -> {
        Long n = num.longValue();
        if (primes.contains(n)) return true;
        else if (primes.stream()
                       .filter(p -> p <= Math.round(Math.sqrt(n)) + 2)
                       .anyMatch(p -> n % p == 0)) {
            return false;
        }
        long p = supplier.getAsLong();
        primes.add(p);
        while (p <= Math.round(Math.sqrt(n))+2) {
            if (n % p == 0) return false;
            p = supplier.getAsLong();
            primes.add(p);
        }
        primes.add(n);
        return true;
    };

    public Predicate<Number> memPrimeQ = Memoization.memoize(primeQ);

    /**
     * Generates primes from 2 up
     *
     * @return IntStream of primes
     */
    public LongStream primes() {
        return LongStream.generate(primeSupplier());
    }

    /**
     * Generates a list of primes
     *
     * @param n
     *        {@code Integer} length of the list
     *
     * @return List of primes
     */
    public LongList primeList(Number n) {
        return new LongList(primes().limit(n.longValue()));
    }

    /**
     * Get the <i>n</i>th prime
     * @param n
     *        Index
     * @return The <i>n</i>th prime assuming a 1 based index
     */
    public Long primeN(Number n) {
        return primes()
                .limit(n.longValue())
                .skip(n.longValue() - 1)
                .findFirst()
                .getAsLong();
    }

    public LongSupplier primeSupplier() {
        InfIterator<Long> iterator = primeIterator();
        return iterator::next;
    }

    public InfIterator<Long> primeIterator() {
        return new InfIterator<Long>() {
            private Set<Long> primes = new HashSet<>(Collections.singletonList(2L));
            private Long prime = 2L;

            private Long nextPrime(Long n) {
                if (primes.contains(n)) return nextPrime(n+2);
                else if (primes.stream().filter(p -> p <= Math.round(Math.sqrt(n)) + 1).noneMatch(p -> n % p == 0)) {
                    primes.add(n);
                    return n;
                }
                else return nextPrime(n+2);
            }

            @Override
            public Long next() {
                Long ret = prime;
                if (prime.equals(2L)) prime = nextPrime(prime+1);
                prime = nextPrime(prime);
                return ret;
            }
        };
    }
}
