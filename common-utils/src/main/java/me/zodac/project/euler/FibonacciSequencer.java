/*
 * BSD Zero Clause License
 *
 * Copyright (c) 2021-2023 zodac.me
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Utility class used to calculate the terms in a Fibonnaci Sequence.
 *
 * <p>
 * There are no limits for any of the methods in this class, so use with care. {@link Integer} and {@link Long} overflows are possible.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_sequence">Fibonnaci Sequence</a>
 */
public final class FibonacciSequencer {

    private static final long INITIAL_FIRST_VALUE = 0L;
    private static final long INITIAL_SECOND_VALUE = 1L;

    private FibonacciSequencer() {

    }

    /**
     * Returns the Fibonnaci Sequence up to the provided {@code numberOfTerms}.
     *
     * <p>
     * The initial values of {@value #INITIAL_FIRST_VALUE} and {@value #INITIAL_SECOND_VALUE} are <b>not</b> included in the output.
     *
     * @param numberOfTerms the number of terms of the sequence to return
     * @return the terms of the sequence
     */
    public static Stream<Long> forTerms(final int numberOfTerms) {
        final Collection<Long> values = new ArrayList<>();
        long firstValue = INITIAL_FIRST_VALUE;
        long secondValue = INITIAL_SECOND_VALUE;

        int counter = 0;
        while (counter < numberOfTerms) {
            final long nextValue = firstValue + secondValue;
            values.add(nextValue);

            firstValue = secondValue;
            secondValue = nextValue;
            counter++;
        }

        return values.stream();
    }

    /**
     * Returns the Fibonnaci Sequence until a value exceedes the provided {@code maxValue}.
     *
     * <p>
     * The initial values of {@value #INITIAL_FIRST_VALUE} and {@value #INITIAL_SECOND_VALUE} <b>are</b> included in the output.
     *
     * @param maxValue the maximum permitted value of the sequence
     * @return the terms of the sequence
     */
    public static Stream<Long> untilMaxValue(final int maxValue) {
        final Collection<Long> values = new ArrayList<>();
        values.add(INITIAL_FIRST_VALUE);
        values.add(INITIAL_SECOND_VALUE);

        long firstValue = INITIAL_FIRST_VALUE;
        long secondValue = INITIAL_SECOND_VALUE;

        while (true) {
            final long nextValue = firstValue + secondValue;
            if (nextValue > maxValue) {
                break;
            }

            values.add(nextValue);

            firstValue = secondValue;
            secondValue = nextValue;
        }

        return values.stream();
    }
}
