/*
 * BSD Zero Clause License
 *
 * Copyright (c) 2021-2025 zodac.net
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

package net.zodac.project.euler;

/**
 * Solution for Problem 3: {@code Largest Prime Factor}.
 *
 * @see <a href="https://projecteuler.net/problem=3">Project Euler, Problem 3</a>
 */
public final class Problem3 {

    private Problem3() {

    }

    /**
     * Determines the prime factors of the input value, then returns the largest factor.
     *
     * @param input the value whose prime factors are to be found
     * @return the largest prime factor
     * @see FactorFinder#primeFactors(long)
     */
    public static long largestPrimeFactor(final long input) {
        return FactorFinder.primeFactors(input)
            .mapToLong(Long::longValue)
            .max()
            .orElse(0L);
    }
}
