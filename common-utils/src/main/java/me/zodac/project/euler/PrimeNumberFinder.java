/*
 * BSD Zero Clause License
 *
 * Copyright (c) 2021-2024 zodac.me
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package me.zodac.project.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to find prime numbers by index. The constructor will use the {@code Sieve of Eratosthenes} algorithm to determine all prime numbers
 * up to a given limit, which can be used to find any prime by index within that limit.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Sieve of Eratosthenes</a>
 */
public final class PrimeNumberFinder {

    private static final int DEFAULT_MAX_PRIME_NUMBER_VALUE = 1_000_000;
    private static final int FIRST_PRIME_NUMBER = 2;

    private final List<Long> primes = new ArrayList<>();

    private PrimeNumberFinder(final int maxValueOfPrimeNumber) {
        createSieveOfPrimes(maxValueOfPrimeNumber);
    }

    /**
     * Creates an instance of {@link PrimeNumberFinder}, where the maximum value of a prime number must be less
     * than {@value #DEFAULT_MAX_PRIME_NUMBER_VALUE}.
     *
     * @return the {@link PrimeNumberFinder} instance
     */
    public static PrimeNumberFinder create() {
        return new PrimeNumberFinder(DEFAULT_MAX_PRIME_NUMBER_VALUE);
    }

    /**
     * Function to find the {@code nth} prime number, where {@code n} is a one-indexed value.
     *
     * @param indexOfPrimeToFind the one-indexed index of the prime to be found
     * @return the {@code nth} prime number
     */
    public long find(final int indexOfPrimeToFind) {
        final int zeroIndexedIndex = indexOfPrimeToFind - 1;
        if (indexOfPrimeToFind <= 0 || indexOfPrimeToFind > primes.size()) {
            throw new IllegalArgumentException(String.format("The index must be between 1 and %s, found: %s", primes.size(), indexOfPrimeToFind));
        }

        return primes.get(zeroIndexedIndex);
    }

    private void createSieveOfPrimes(final int maxValueOfPrimeNumber) {
        final boolean[] isPrime = new boolean[maxValueOfPrimeNumber + 1];

        for (int i = FIRST_PRIME_NUMBER; i <= maxValueOfPrimeNumber; i++) {
            isPrime[i] = true;
        }

        for (int p = FIRST_PRIME_NUMBER; p * p <= maxValueOfPrimeNumber; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= maxValueOfPrimeNumber; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = FIRST_PRIME_NUMBER; i <= maxValueOfPrimeNumber; i++) {
            if (isPrime[i]) {
                primes.add((long) i);
            }
        }
    }
}
