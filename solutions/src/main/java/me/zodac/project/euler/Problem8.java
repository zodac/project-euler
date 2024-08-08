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

import java.util.List;

/**
 * Solution for Problem 8: {@code Largest Product in a Series}.
 *
 * @see <a href="https://projecteuler.net/problem=8">Project Euler, Problem 8</a>
 */
public final class Problem8 {

    private Problem8() {

    }

    /**
     * Given an input {@link List} of {@link Long}s, we find the sequence of numbers (of size {@code windowSize}) which creates the largest product.
     *
     * @param input      the input {@link List} of {@link Long}s
     * @param windowSize the size of the window for which to calculate the product
     * @return the largest product
     */
    public static long findGreatestProductOfAdjacentDigits(final List<Long> input, final int windowSize) {
        final int startIndex = windowSize - 1;
        final int size = input.size();

        long max = Long.MIN_VALUE;
        for (int i = startIndex; i < size; i++) {
            final int startOfWindow = i - windowSize + 1;
            final int endOfWindow = i + 1;

            final List<Long> window = input.subList(startOfWindow, endOfWindow);
            final long productOfWindow = window
                .stream()
                .reduce(1L, (first, second) -> first * second);

            if (productOfWindow > max) {
                max = productOfWindow;
            }
        }

        return max;
    }
}
