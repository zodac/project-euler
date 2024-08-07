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
import java.util.List;
import java.util.stream.LongStream;

/**
 * Solution for Problem 6: {@code Sum Square Difference}.
 *
 * @see <a href="https://projecteuler.net/problem=6">Project Euler, Problem 6</a>
 */
public final class Problem6 {

    private Problem6() {

    }

    /**
     * Given a {@link Long} range (defined by {@code start} and {@code end}), calculate the 'sum of squares', and the 'square of sums', then return
     * the difference.
     *
     * <p>
     * The 'sum of squares' is:
     *
     * <pre>
     *      1^2 + 2^2 + ... n^2
     * </pre>
     *
     * <p>
     * The 'square of sums' is:
     *
     * <pre>
     *      (1 + 2 + ... n)^2
     * </pre>
     *
     * @param start the start of the range of {@link Long}s (inclusive)
     * @param end   the end of the range of {@link Long}s (inclusive)
     * @return the difference between the 'sum of squares' and 'square of sums'
     */
    public static long differenceOfSumAndSquares(final long start, final long end) {
        final List<Long> range = LongStream.range(start, end + 1).boxed().toList();
        final long sumOfSquares = sumOfSquares(range);
        final long squareOfSums = squareOfSums(range);
        return Math.abs(squareOfSums - sumOfSquares);
    }

    private static long sumOfSquares(final Collection<Long> range) {
        return range
            .stream()
            .mapToLong(l -> l * l)
            .sum();
    }

    private static long squareOfSums(final Collection<Long> range) {
        final long sum = range
            .stream()
            .mapToLong(l -> l)
            .sum();
        return sum * sum;
    }
}
