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

import net.zodac.project.euler.util.MathUtils;

/**
 * Solution for Problem 2: {@code Even Fibonacci Numbers}.
 *
 * @see <a href="https://projecteuler.net/problem=2">Project Euler, Problem 2</a>
 */
public final class Problem2 {

    private Problem2() {

    }

    /**
     * Retrieves all Fibonnaci values less than the {@code maxFibonacciValue}, then sums all even values.
     *
     * @param maxFibonacciValue the maximum value for the Fibonacci sequence to count to
     * @return the sum of all even Fibonacci values less than {@code maxFibonacciValue}
     * @see FibonacciSequencer#untilMaxValue(int)
     * @see MathUtils#isEven(long)
     */
    public static long sumEvenFibonacciValues(final int maxFibonacciValue) {
        return FibonacciSequencer.untilMaxValue(maxFibonacciValue)
            .filter(MathUtils::isEven)
            .mapToLong(Long::longValue)
            .sum();
    }
}
