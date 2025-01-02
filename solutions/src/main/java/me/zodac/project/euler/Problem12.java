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

/**
 * Solution for Problem 12: {@code Highly Divisible Triangular Number}.
 *
 * @see <a href="https://projecteuler.net/problem=12">Project Euler, Problem 12</a>
 */
public final class Problem12 {

    private Problem12() {

    }

    /**
     * Increments through every possible triangular number, until one is found with a number of factors greater than
     * {@code numberOfFactorsToExceed}.
     *
     * @param numberOfFactorsToExceed the number of prime factors the triangular number must have <b>more</b> than
     * @return the first triangular number with the wanted number of factors
     * @see FactorFinder
     * @see <a href="https://en.wikipedia.org/wiki/Triangular_number">Triangular Number</a>
     * @see <a href="https://projecteuler.net/thread=12;page=2#4616">Time-efficient solution from here</a>
     */
    public static long findTriangularNumber(final int numberOfFactorsToExceed) {
        int n = 0;
        int currentTriangularNumber = 0;
        int numberOfFactors = 0;

        while (numberOfFactors < numberOfFactorsToExceed) {
            n++;
            currentTriangularNumber += n;

            numberOfFactors = 0;
            for (int j = 1; j < Math.sqrt(currentTriangularNumber); j++) {
                if (currentTriangularNumber % j == 0) {
                    numberOfFactors++;
                }
            }

            numberOfFactors = 2 * numberOfFactors - 1;
        }

        return currentTriangularNumber;
    }
}
