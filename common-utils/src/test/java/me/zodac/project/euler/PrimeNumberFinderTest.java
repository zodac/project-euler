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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for {@link PrimeNumberFinder}.
 */
class PrimeNumberFinderTest {

    private final PrimeNumberFinder primeNumberFinder = PrimeNumberFinder.create();

    @ParameterizedTest
    @CsvSource({
        "1,2",
        "5,11",
        "7,17",
        "16,53",
        "22,79",
        "1049,8377",
        "10000,104729",
        "78498,999983",
    })
    void testFind(final int wantedIndex, final long expectedPrimeNumber) {
        final long output = primeNumberFinder.find(wantedIndex);
        assertThat(output)
            .isEqualTo(expectedPrimeNumber);
    }

    @Test
    void testFind_givenInvalidIndex() {
        assertThatThrownBy(() -> primeNumberFinder.find(78_499))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("The index must be between 1 and 78498, found: 78499");
    }

    @Test
    void testFind_givenNegativeIndex() {
        assertThatThrownBy(() -> primeNumberFinder.find(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("The index must be between 1 and 78498, found: -1");
    }
}