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

/**
 * Utility class with {@link String}-based functions.
 */
public final class StringUtils {

    private StringUtils() {

    }

    /**
     * Checks if the {@code input} is a palindrome (reads the same both ways).
     *
     * @param input the {@link String} to check
     * @return {@code true} if the {@code input} is a palindrome
     */
    public static boolean isPalindrome(final String input) {
        final String reversedInput = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversedInput);
    }
}
