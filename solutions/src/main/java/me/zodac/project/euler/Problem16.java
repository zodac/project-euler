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

import java.math.BigDecimal;

/**
 * Solution for Problem 16: {@code Power Digit Sum}.
 *
 * @see <a href="https://projecteuler.net/problem=16">Project Euler, Problem 16</a>
 */
public final class Problem16 {

    private Problem16() {

    }

    /**
     * Calculates the exponent for the given number, then sums the digits.
     *
     * @param number   the number to raise to the given exponent
     * @param exponent the exponent to raise the number by
     * @return the sum of digits
     */
    public static long sumOfDigits(final int number, final int exponent) {
        final BigDecimal value = BigDecimal.valueOf(number);
        final BigDecimal result = value.pow(exponent);
        final String resultAsString = String.valueOf(result);

        long total = 0L;
        final int numberOfResults = resultAsString.length();
        for (int i = 0; i < numberOfResults; i++) {
            total += Character.digit(resultAsString.charAt(i), 10);
        }

        return total;
    }
}
