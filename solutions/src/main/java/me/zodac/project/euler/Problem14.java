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

/**
 * Solution for Problem 14: {@code Longest Collatz Sequence}.
 *
 * @see <a href="https://projecteuler.net/problem=14">Project Euler, Problem 14</a>
 */
public final class Problem14 {

    private Problem14() {

    }

    /**
     * Calculates the length of the Collatz sequence of all values less than {@code maxStartValue}, and returns the start value that has the longest
     * sequence length.
     *
     * @param maxStartValue check for Collatz sequence lengths of all values less than this
     * @return the value that generates the longest Collatz sequence
     */
    public static long calculateLargestCollatzSequenceStartValue(final int maxStartValue) {
        int maxLength = 0;
        int startValueWithLargestLength = 0;
        final CollatzSequenceCalculator collatzSequenceCalculator = CollatzSequenceCalculator.create();

        for (int i = 1; i < maxStartValue; i++) {
            final int newLength = collatzSequenceCalculator.calculateSequenceLength(i);

            if (newLength > maxLength) {
                maxLength = newLength;
                startValueWithLargestLength = i;
            }
        }

        return startValueWithLargestLength;
    }
}
