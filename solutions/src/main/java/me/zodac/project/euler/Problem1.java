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

import java.util.Set;
import java.util.stream.IntStream;
import me.zodac.project.euler.util.MathUtils;

/**
 * Solution for Problem 1: {@code Multiples of 3 or 5}.
 *
 * @see <a href="https://projecteuler.net/problem=1">Project Euler, Problem 1</a>
 */
public final class Problem1 {

    private static final int STARTING_VALUE = 1;
    private static final Set<Integer> VALID_DIVISORS = Set.of(3, 5);

    private Problem1() {

    }

    /**
     * Sums all values that are divisible by {@link #VALID_DIVISORS}. Starting from {@value #STARTING_VALUE}, we iterate through all values until
     * {@code limit} and check if they are divisible.
     *
     * <p>
     * If a value is divisible by multiple divisors, it will only be counted once.
     *
     * @param limit the maximum value to check
     * @return the sum of all values divisible by {@link #VALID_DIVISORS}.
     */
    public static long sumMultiplesOf3Or5(final int limit) {
        return IntStream.range(STARTING_VALUE, limit)
            .filter(Problem1::isDivisibleByAnyValidDivisor)
            .sum();
    }

    private static boolean isDivisibleByAnyValidDivisor(final int i) {
        for (final int validDivisor : VALID_DIVISORS) {
            if (MathUtils.isDivisibleBy(i, validDivisor)) {
                return true;
            }
        }
        return false;
    }
}
