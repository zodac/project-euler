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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for {@link FibonacciSequencer}.
 */
class FibonacciSequencerTest {

    @ParameterizedTest
    @CsvSource({
        "10,10,89,231",
        "100,100,7_540_113_804_746_346_429,6_334_266_236_422_402_379",
    })
    void testForTerms(final int input, final int expectedSize, final long expectedMaxValue, final long expectedSum) {
        final List<Long> output = FibonacciSequencer.forTerms(input).toList();
        assertThat(output)
            .hasSize(expectedSize);
        assertThat(output.stream().mapToLong(Long::longValue).max().orElse(0L))
            .isEqualTo(expectedMaxValue);
        assertThat(output.stream().mapToLong(Long::longValue).sum())
            .isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @CsvSource({
        "89,12,89,232",
        "5_000_000,34,3_524_578,9_227_464",
    })
    void testUntilMaxValue(final int input, final int expectedSize, final long expectedMaxValue, final long expectedSum) {
        final List<Long> output = FibonacciSequencer.untilMaxValue(input).toList();
        assertThat(output)
            .hasSize(expectedSize);
        assertThat(output.stream().mapToLong(Long::longValue).max().orElse(0L))
            .isEqualTo(expectedMaxValue);
        assertThat(output.stream().mapToLong(Long::longValue).sum())
            .isEqualTo(expectedSum);
    }
}
