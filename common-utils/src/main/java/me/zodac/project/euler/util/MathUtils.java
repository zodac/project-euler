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

package me.zodac.project.euler.util;

import java.util.Collection;

/**
 * Utility class with {@link Math}-based functions.
 */
public final class MathUtils {

    private MathUtils() {

    }

    /**
     * Calculates the Greatest Common Divisor (also known as the Highest Common Factor) of the provided {@code long}s.
     *
     * @param first  the first {@code long}, so at least one value is provided
     * @param others the {@code long}s to check
     * @return the GCD of the provided {@code long}s
     * @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest Common Divisor</a>
     */
    public static long greatestCommonDivisor(final long first, final long... others) {
        long gcd = first;
        for (final long input : others) {
            gcd = gcd(gcd, input);
        }

        return gcd;
    }

    private static long gcd(final long x, final long y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

    /**
     * Checks whether the {@code input} is divisible by the given {@code divisor}.
     *
     * @param input   the input
     * @param divisor the divisor
     * @return {@code true} if the {@code input} is divisible by the given {@code divisor}
     */
    public static boolean isDivisibleBy(final long input, final long divisor) {
        try {
            return input % divisor == 0;
        } catch (final ArithmeticException ignored) {
            return false;
        }
    }

    /**
     * Checks if the input {@code long} is even.
     *
     * @param value the {@code long} to check
     * @return {@code true} if the {@code long} is even
     */
    public static boolean isEven(final long value) {
        return isDivisibleBy(value, 2L);
    }

    /**
     * Checks if the input {@code long} is odd.
     *
     * @param value the {@code long} to check
     * @return {@code true} if the {@code long} is odd
     * @see #isEven(long)
     */
    public static boolean isOdd(final long value) {
        return !isEven(value);
    }

    /**
     * Calculates the Lowest Common Multiple (also known as Least Common Multiple) of the provided {@link Long}s.
     *
     * @param inputs the {@link Long}s to check
     * @return the LCM of the provided {@link Long}s
     * @throws IllegalArgumentException thrown if the input {@link Collection#isEmpty()}
     * @see <a href="https://en.wikipedia.org/wiki/Least_common_multiple">Lower Common Multiple</a>
     */
    public static long lowestCommonMultiple(final Collection<Long> inputs) {
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }

        long lcm = 1;
        for (final long input : inputs) {
            lcm = lcm(lcm, input);
        }

        return lcm;
    }

    private static long lcm(final long number1, final long number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }

        final long gcd = greatestCommonDivisor(number1, number2);
        return Math.abs(number1 * number2) / gcd;
    }
}
