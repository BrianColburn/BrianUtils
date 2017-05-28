package brian;

import brian.functional.InfIterator;
import brian.functional.Memoization;
import brian.utils.list.IntList;
import brian.utils.list.LongList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class Prime {
    private static Set<Long> primes = new HashSet<>(Collections.singletonList(2L));

    public static Predicate<Number> primeQ = (Number num) -> {
        Long n = num.longValue();
        if (primes.contains(n)) return true;
        else if (primes.stream()
                       .filter(p -> p <= Math.round(Math.sqrt(n)) + 1)
                       .noneMatch(p -> n % p == 0)) {
            primes.add(n);
            return true;
        }
        return false;
    };

    public static Predicate<Number> memPrimeQ = Memoization.memoize(primeQ);

    /**
     * Generates primes from 2 up
     *
     * @return IntStream of primes
     */
    public static LongStream primes() {
        return LongStream.iterate(2, i -> i + 1).filter(primeQ::test);
    }

    /**
     * Generates a list of primes
     *
     * @param n
     *        {@code Integer} length of the list
     *
     * @return List of primes
     */
    public static LongList primeList(Number n) {
        return new LongList(primes().limit(n.longValue()));
    }

    /**
     * Get the <i>n</i>th prime
     * @param n
     *        Index
     * @return The <i>n</i>th prime assuming a 1 based index
     */
    public static Long primeN(Number n) {
        return primes()
                .limit(n.longValue())
                .skip(n.longValue() - 1)
                .findFirst()
                .getAsLong();
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
