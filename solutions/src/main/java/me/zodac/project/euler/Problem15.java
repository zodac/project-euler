/*
 * BSD Zero Clause License
 *
 * Copyright (c) 2021-2025 zodac.me
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

import java.math.BigInteger;

/**
 * Solution for Problem 15: {@code Lattice Paths}.
 *
 * @see <a href="https://projecteuler.net/problem=15">Project Euler, Problem 15</a>
 */
public final class Problem15 {

    private Problem15() {

    }

    /**
     * Calculates the number of routes from the start of an {@code n x n} grid. This is done calculating the
     * <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">Binomial Coefficient</a>, as we can assume we only move in two directions (down
     * and right).
     *
     * @param sizeOfGrid the size of the grid
     * @return the number of routes
     */
    public static long calculateNumberOfRoutesFromStartToEnd(final int sizeOfGrid) {
        final int totalSteps = sizeOfGrid << 1;
        return binomialCoefficient(totalSteps, sizeOfGrid);
    }

    private static long binomialCoefficient(final int n, final int k) {
        if (k > n) {
            return 0;
        }

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        // Calculate C(n, k) = n! / (k! * (n-k)!)
        for (int i = 1; i <= k; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i + 1));
            denominator = denominator.multiply(BigInteger.valueOf(i));
        }

        return numerator.divide(denominator).longValue();
    }
}
