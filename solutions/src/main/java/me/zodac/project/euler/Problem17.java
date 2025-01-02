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

import java.util.regex.Pattern;

/**
 * Solution for Problem 17: {@code Number Letter Counts}.
 *
 * @see <a href="https://projecteuler.net/problem=17">Project Euler, Problem 17</a>
 */
public final class Problem17 {

    private static final Pattern CHARACTERS_TO_IGNORE = Pattern.compile("(-|\\s+)");

    private Problem17() {

    }

    /**
     * For a range of inputs from {@code start} to {@code end}, converts each number to the English representation, and then counts the number of
     * letters for each converted value. Spaces and hyphens ({@code -}) are ignored in the count.
     *
     * @param start the start of the range of values (inclusive)
     * @param end   the end of the range of values (inclusive)
     * @return the sum of letters for all converted numbers
     * @see NumberToWords#convert(int)
     */
    public static long writeNumbersAndCountLetters(final int start, final int end) {
        long total = 0L;

        for (int i = start; i <= end; i++) {
            final String writtenOutNumber = NumberToWords.convert(i);
            final String cleanedNumber = CHARACTERS_TO_IGNORE.matcher(writtenOutNumber).replaceAll("");
            total += cleanedNumber.length();
        }

        return total;
    }
}
