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

package me.zodac.project.euler.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for {@link MathUtils}.
 */
class MathUtilsTest {

    @ParameterizedTest
    @CsvSource({
        "10,5,true",
        "-10,5,true",
        "10,-5,true",
        "-10,-5,true",
        "10,4,false",
        "10,-4,false",
        "10,0,false",
    })
    void testIsDivisibleBy(final int input, final int divisor, final boolean expected) {
        final boolean output = MathUtils.isDivisibleBy(input, divisor);
        assertThat(output)
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "2,true",       // Even number
        "-2,true",      // Even negative number
        "3,false",      // Odd number
        "-3,false",     // Odd negative number
        "0,true",       // Zero
    })
    void testIsEven(final int input, final boolean expected) {
        final boolean output = MathUtils.isEven(input);
        assertThat(output)
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "3,true",        // Odd number
        "-3,true",       // Odd negative number
        "2,false",       // Even number
        "-2,false",      // Even negative number
        "0,false",       // Zero
    })
    void testIsOdd(final int input, final boolean expected) {
        final boolean output = MathUtils.isOdd(input);
        assertThat(output)
            .isEqualTo(expected);
    }
}
