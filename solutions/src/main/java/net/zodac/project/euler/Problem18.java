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

package net.zodac.project.euler;

import java.util.List;
import net.zodac.project.euler.util.StringUtils;

/**
 * Solution for Problem 18: {@code Maximum Path Sum I}.
 *
 * @see <a href="https://projecteuler.net/problem=18">Project Euler, Problem 18</a>
 */
public final class Problem18 {

    private Problem18() {

    }

    /**
     * Given a triangle of numbers in the form of a {@link List} of {@link String}s, calculate the highest value path traversing from the top of the
     * triangle to the bottom.
     *
     * @param inputRows the input triangle rows
     * @return the maximum path
     */
    public static long calculateMaxPathOfTriangle(final List<String> inputRows) {
        final int size = inputRows.size();
        final long[][] rows = new long[size][];

        for (int i = 0; i < size; i++) {
            final String[] numbers = StringUtils.WHITESPACE_PATTERN.split(inputRows.get(i));

            rows[i] = new long[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                rows[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        // Dynamic programming approach to find max path sum
        // From the bottom (starting at 2nd-last row), check each value in the row against the value below it and below-right (the 'roots')
        // Find the max of the two options, then iterate through the row to find the max value in the row
        // Continue up the triangle, and store the result in the root of the array
        for (int i = rows.length - 2; i >= 0; i--) {
            for (int j = 0; j < rows[i].length; j++) {
                rows[i][j] += Math.max(rows[i + 1][j], rows[i + 1][j + 1]);
            }
        }

        // Print the result
        return rows[0][0];
    }
}
