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

/**
 * Solution for Problem 10: {@code Summation of Primes}.
 *
 * @see <a href="https://projecteuler.net/problem=10">Project Euler, Problem 10</a>
 */
public final class Problem10 {

    private Problem10() {

    }

    /**
     * Calculates the sum of all prime numbers below the provided {@code maxPrime} value.
     *
     * @param maxPrime the number beneath which all prime numbers should be summed
     * @return the sum of primes
     */
    public static long sumOfPrimes(final int maxPrime) {
        final PrimeNumberFinder primeNumberFinder = PrimeNumberFinder.create(maxPrime);
        return primeNumberFinder
            .allPrimes()
            .sum();
    }
}
