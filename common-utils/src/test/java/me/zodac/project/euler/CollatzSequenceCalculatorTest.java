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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit tests for {@link CollatzSequenceCalculator}.
 */
class CollatzSequenceCalculatorTest {

    private final CollatzSequenceCalculator collatzSequenceCalculator = CollatzSequenceCalculator.create();

    @ParameterizedTest
    @CsvSource({
        "13,10",
        "5000,29",
        "837799,525",
    })
    void testCalculateSequenceLength(final long startValue, final int sequenceLength) {
        final int output = collatzSequenceCalculator.calculateSequenceLength(startValue);
        assertThat(output)
            .isEqualTo(sequenceLength);
    }

    @ParameterizedTest
    @ValueSource(longs = {-1L, 0L})
    void testCalculateSequenceLength_givenInvalidInputsIndex(final long input) {
        assertThatThrownBy(() -> collatzSequenceCalculator.calculateSequenceLength(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Value must be a positive integer (greater than 0), found: " + input);
    }
}
