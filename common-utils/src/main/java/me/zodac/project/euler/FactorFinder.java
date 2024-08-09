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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import me.zodac.project.euler.util.MathUtils;

/**
 * Utility class which finds the factors of a {@code long}.
 */
public final class FactorFinder {

    private static final long INVALID_PRIME_NUMBER = 1L;
    private static final long FIRST_EVEN_PRIME_NUMBER = 2L;
    private static final long FIRST_ODD_PRIME_NUMBER = 3L;

    private FactorFinder() {

    }

    /**
     * Determines the factors for the provided {@code input}.
     *
     * @param input the number whose factors to find
     * @return the factors
     */
    public static Stream<Long> factors(final long input) {
        final Collection<Long> factors = new HashSet<>();
        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                factors.add((long) i);
            }
        }
        return factors.stream();
    }

    /**
     * Determines the prime factors for the provided {@code input}.
     *
     * @param input the number whose prime factors to find
     * @return the prime factors
     */
    public static Stream<Long> primeFactors(final long input) {
        final Collection<Long> primeFactors = new HashSet<>();
        // Mutable value so we don't change input
        long value = input;

        // Check if input is even, keep dividing until it is odd
        while (MathUtils.isEven(value)) {
            primeFactors.add(FIRST_EVEN_PRIME_NUMBER);
            value /= FIRST_EVEN_PRIME_NUMBER;
        }

        // Because we will be dividing by the facors, we only need to check for primes until the square root of the value
        final double end = Math.sqrt(value);
        for (long l = FIRST_ODD_PRIME_NUMBER; Double.compare(l, end) < 1; l += FIRST_EVEN_PRIME_NUMBER) {
            // Iterate until a factor is found, then divide input
            while (MathUtils.isDivisibleBy(value, l)) {
                primeFactors.add(l);
                value /= l;
            }
        }

        // Finally, value is a prime number greater than 2
        if (value != INVALID_PRIME_NUMBER) {
            primeFactors.add(value);
        }

        return primeFactors.stream();
    }
}
