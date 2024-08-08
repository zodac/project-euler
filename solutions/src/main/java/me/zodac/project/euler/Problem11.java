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
 * Solution for Problem 11: {@code Largest Product in a Grid}.
 *
 * @see <a href="https://projecteuler.net/problem=11">Project Euler, Problem 11</a>
 */
public final class Problem11 {

    private Problem11() {

    }

    /**
     * Given a 2D grid of numbers, find the sequence of numbers of size {@code windowSize} with the largest product. The sequence can be in any
     * direction (left/right, up/down, diagonally-right/diagonally-left).
     *
     * @param grid the 2D array of numbers
     * @param windowSize the size of the window for which to calculate the product
     * @return the largest product of a valid sequence of numbers
     */
    public static long largestProductOfSequenceInGrid(final long[][] grid, final int windowSize) {
        long max = Long.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (final Direction direction : Direction.values()) {
                    final long newValue = productOfDirection(i, j, grid, windowSize, direction);

                    if (newValue > max) {
                        max = newValue;
                    }
                }
            }
        }

        return max;
    }

    private static long productOfDirection(final int i, final int j, final long[][] grid, final int windowSize, final Direction direction) {
        try {
            long total = 1L;
            for (int a = 0; a < windowSize; a++) {
                total *= switch (direction) {
                    case DIAGONAL_DOWN_RIGHT -> grid[i + a][j + a];
                    case DIAGONAL_DOWN_LEFT -> grid[i + a][j - a];
                    case DOWN -> grid[i + a][j];
                    case RIGHT -> grid[i][j + a];
                };
            }
            return total;
        } catch (final ArrayIndexOutOfBoundsException ignored) {
            return Long.MIN_VALUE; // Return lowest possible value, best practice since we're looking for a max value (technicall could be negative)
        }
    }

    private enum Direction {
        DIAGONAL_DOWN_RIGHT,
        DIAGONAL_DOWN_LEFT,
        DOWN,
        RIGHT
    }
}
