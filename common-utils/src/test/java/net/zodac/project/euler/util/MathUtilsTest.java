/*
 * BSD Zero Clause License
 *
 * Copyright (c) 2021-2025 zodac.net
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

package net.zodac.project.euler.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link MathUtils}.
 */
class MathUtilsTest {

    @ParameterizedTest
    @MethodSource("provideForGreatestCommonDivisor")
    void testGreatestCommonDivisor(final long input, final long[] additionalInputs, final long expected) {
        final long output = MathUtils.greatestCommonDivisor(input, additionalInputs);
        assertThat(output)
            .isEqualTo(expected);
    }

    private static Stream<Arguments> provideForGreatestCommonDivisor() {
        return Stream.of(
            Arguments.of(9L, new long[] {36L, 54, 99}, 9L),                                             // Input is divisor of others
            Arguments.of(36L, new long[] {54L, 90}, 18L),                                               // All inputs share divisor
            Arguments.of(5L, new long[] {}, 5L),                                                        // Input with no additional inputs
            Arguments.of(9L, new long[] {0L, 36L}, 9L),                                                 // Input contains zeros
            Arguments.of(0L, new long[] {0L, 0L}, 0L),                                                  // Input only has 0s
            Arguments.of(9L, new long[] {-36L, 54L, 99L}, 9L),                                          // Single negative number
            Arguments.of(9L, new long[] {-36L, -54L, -99L}, 9L),                                        // Only negative numbers
            Arguments.of(10_241_191_004_509L, new long[] {20_482_382_009_018L}, 10_241_191_004_509L)    // Input greater than int value
        );
    }

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

    @ParameterizedTest
    @MethodSource("provideForLowestCommonMultiple")
    void testLowestCommonMultiple(final List<Long> input, final long expected) {
        final long output = MathUtils.lowestCommonMultiple(input);
        assertThat(output)
            .isEqualTo(expected);
    }

    private static Stream<Arguments> provideForLowestCommonMultiple() {
        return Stream.of(
            Arguments.of(List.of(6L, 9L, 18L, 15L, 27L, 54L), 270L),                    // Multiple inputs with common divisors
            Arguments.of(List.of(1L, 0L, 3L), 0L),                                      // Inputs including 0
            Arguments.of(List.of(5L), 5L),                                           // Single input
            Arguments.of(List.of(7L, 13L, 29L), 2_639L),                                // Inputs are prime numbers
            Arguments.of(List.of(10_241_191_004_509L, 20_482_382_009_018L), 877_580L)   // Input greater than int value
        );
    }

    @Test
    void testLowestCommonMultiple_givenInvalidInputs() {
        final List<Long> input = List.of();
        assertThatThrownBy(() -> MathUtils.lowestCommonMultiple(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Input cannot be empty");
    }
}
