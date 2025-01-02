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
 * Solution for Problem 9: {@code Special Pythagorean Triplet}.
 *
 * @see <a href="https://projecteuler.net/problem=9">Project Euler, Problem 9</a>
 */
public final class Problem9 {

    private Problem9() {

    }

    /**
     * Find a {@code Pythagorean Triple} where the sum of the values add up to a provided {@code expectedSum}. When these values are found, multiply
     * them and return the product.
     *
     * <p>
     * A {@code Pythagorean Triple} is one with three natural numbers <b>a</b> {@literal <} <b>b</b> {@literal <} <b>c</b>, for which:
     * <pre>
     *  a^2 + b^2 = c^2
     * </pre>
     *
     * @param expectedSum the expected sum for the {@code Pythagorean Triple} to add up to
     * @return the product of the matching {@code Pythagorean Triple}
     * @see <a href="https://en.wikipedia.org/wiki/Pythagorean_triple">Pythagorean triple</a>
     */
    public static long productOfWantedPythagoreanTriple(final int expectedSum) {
        final int boundary = expectedSum / 2; // No need to go all the way to the end, since a < b < c

        for (int a = 0; a < boundary; a++) {
            for (int b = a + 1; b < boundary; b++) {
                for (int c = b + 1; c < boundary; c++) {
                    if (isSumExpectedValue(expectedSum, a, b, c) && isPythagoreanTriplet(a, b, c)) {
                        return (long) a * b * c;
                    }
                }
            }
        }

        return 0L;
    }

    private static boolean isSumExpectedValue(final int expectedSum, final int a, final int b, final int c) {
        return a + b + c == expectedSum;
    }

    private static boolean isPythagoreanTriplet(final int a, final int b, final int c) {
        return (a * a) + (b * b) == (c * c);
    }
}
