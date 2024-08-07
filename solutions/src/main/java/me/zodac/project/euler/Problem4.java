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

import me.zodac.project.euler.util.StringUtils;

/**
 * Solution for Problem 4: {@code Largest Palindrome Product}.
 *
 * @see <a href="https://projecteuler.net/problem=4">Project Euler, Problem 4</a>
 */
public final class Problem4 {

    private static final int BASE_TEN_VALUE = 10;

    private Problem4() {

    }

    /**
     * Multiplies digits of size {@code numberOfDigits}, and returns the largest product that is a palindrome (equal reading both ways).
     *
     * @param numberOfDigits the size (number of digits) of the number to multiple
     * @return the palindrome product
     */
    public static long largestPalindromeProductWithNumbersOfSize(final long numberOfDigits) {
        final int start = ((Double) StrictMath.pow(BASE_TEN_VALUE, numberOfDigits - 1.0D)).intValue();
        final int end = ((Double) StrictMath.pow(BASE_TEN_VALUE, numberOfDigits)).intValue();

        int max = start;

        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                final int product = i * j;

                if (StringUtils.isPalindrome(String.valueOf(product)) && product > max) {
                    max = product;
                }
            }
        }

        return max;
    }
}
