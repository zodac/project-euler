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
 * Unit tests for {@link NumberToWords}.
 */
class NumberToWordsTest {

    @ParameterizedTest
    @CsvSource({
        "1,one",
        "19,nineteen",
        "20,twenty",
        "24,twenty-four",
        "99,ninety-nine",
        "100,one hundred",
        "315,three hundred and fifteen",
        "999,nine hundred and ninety-nine",
        "1000,one thousand",
        "9999,nine thousand nine hundred and ninety-nine",
    })
    void testConvert(final int input, final String expected) {
        final String output = NumberToWords.convert(input);
        assertThat(output)
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10_000})
    void testFind_givenInvalidInputsIndex(final int input) {
        assertThatThrownBy(() -> NumberToWords.convert(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Expected input between 1 and 9999, found: " + input);
    }
}
