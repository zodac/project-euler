/*
 * BSD Zero Clause License
 *
 * Copyright (c) 2021-2023 zodac.me
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

/**
 * Utility class with {@link Math}-based functions.
 */
public final class MathUtils {

    private MathUtils() {

    }

    /**
     * Checks whether the {@code input} is divisible by the given {@code divisor}.
     *
     * @param input   the input
     * @param divisor the divisor
     * @return {@code true} if the {@code input} is divisible by the given {@code divisor}
     */
    public static boolean isDivisibleBy(final int input, final int divisor) {
        try {
            return input % divisor == 0;
        } catch (final ArithmeticException e) {
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
        return value % 2 == 0;
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
}
