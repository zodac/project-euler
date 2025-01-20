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

package net.zodac.project.euler.util;

import java.util.regex.Pattern;

/**
 * Utility class with {@link String}-based functions.
 */
public final class StringUtils {

    /**
     * {@link Pattern} to find new lines.
     */
    public static final Pattern NEW_LINE_PATTERN = Pattern.compile("\\r?\\n");

    /**
     * {@link Pattern} to find whitespaces (of any length).
     */
    public static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");

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
