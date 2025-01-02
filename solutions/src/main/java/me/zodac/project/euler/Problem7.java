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

/**
 * Solution for Problem 7: {@code 10001st Prime}.
 *
 * @see <a href="https://projecteuler.net/problem=7">Project Euler, Problem 7</a>
 */
public final class Problem7 {

    private Problem7() {

    }

    /**
     * Returns the 10,001st prime number.
     *
     * @param index the one-indexed index of the prime to be found
     * @return the wanted prime number
     * @see PrimeNumberFinder#find(int)
     */
    public static long wantedPrimeByIndex(final int index) {
        final PrimeNumberFinder primeNumberFinder = PrimeNumberFinder.create();
        return primeNumberFinder.find(index);
    }
}
