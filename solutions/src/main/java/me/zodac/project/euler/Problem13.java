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

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Solution for Problem 13: {@code Large Sum}.
 *
 * @see <a href="https://projecteuler.net/problem=13">Project Euler, Problem 13</a>
 */
public final class Problem13 {

    private Problem13() {

    }

    /**
     * Given a {@link Collection} of {@link String}s, where each {@link String} represents a large number (too large to be a {@link Long}). These
     * values are summed together, then the first {@code numberOfLeadingDigitsToReturn} digits of the result are returned.
     *
     * @param largeNumbers                  the numbers
     * @param numberOfLeadingDigitsToReturn the number of leading digits of the result to be returned
     * @return the {@code numberOfLeadingDigitsToReturn} leading digits
     */
    public static long sumAndReturnLeadingDigits(final Collection<String> largeNumbers, final int numberOfLeadingDigitsToReturn) {
        BigDecimal total = BigDecimal.ZERO;

        for (final String largeNumber : largeNumbers) {
            final BigDecimal bigDecimal = new BigDecimal(largeNumber); // NOPMD: AvoidInstantiatingObjectsInLoops - Need to convert here
            total = total.add(bigDecimal);
        }

        final String leadingDigits = total.toPlainString().substring(0, numberOfLeadingDigitsToReturn);
        return Long.parseLong(leadingDigits);
    }
}
