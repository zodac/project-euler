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

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class used to calculate the length of a Collatz sequence for a given value.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Collatz_conjecture">Collatz conjecture</a>
 */
public final class CollatzSequenceCalculator {

    private final Map<Long, Integer> cachedSequenceLengths = new HashMap<>();

    private CollatzSequenceCalculator() {
        cachedSequenceLengths.put(1L, 1);
    }

    /**
     * Creates an instance of {@link CollatzSequenceCalculator}.
     *
     * @return the {@link CollatzSequenceCalculator}
     */
    public static CollatzSequenceCalculator create() {
        return new CollatzSequenceCalculator();
    }

    /**
     * Calculates the length of the Collatz sequence of the provided {@code startValue}.
     *
     * @param startValue the value to start the Collatz sequence
     * @return the length of the Collatz sequence
     * @throws IllegalStateException thrown if {@code startValue} is not a positive integer
     */
    public int calculateSequenceLength(final long startValue) {
        if (startValue <= 0) {
            throw new IllegalArgumentException("Value must be a positive integer (greater than 0), found: " + startValue);
        }

        final int length = calculate(startValue, 0);
        cachedSequenceLengths.put(startValue, length);
        return length;
    }

    private int calculate(final long startValue, final int currentLength) {
        // Since we're checking the cache, we need to make sure the cache is populated with the correct length for input 1
        // This avoids us needing to check for an end state in addition to checking the cache
        if (cachedSequenceLengths.containsKey(startValue)) {
            return currentLength + cachedSequenceLengths.getOrDefault(startValue, 0);
        }

        final int newLength = currentLength + 1;
        if (startValue % 2 == 0) {
            return calculate(startValue / 2, newLength);
        }

        return calculate(3 * startValue + 1, newLength);
    }
}
