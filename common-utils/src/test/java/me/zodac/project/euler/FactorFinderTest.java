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

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.checkerframework.nullaway.com.google.common.collect.ImmutableSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link FactorFinder}.
 */
class FactorFinderTest {

    @ParameterizedTest
    @MethodSource("provideForFactors")
    void testFactors(final long input, final Set<Long> expected) {
        final List<Long> output = FactorFinder.factors(input).toList();
        assertThat(output)
            .hasSameElementsAs(expected);
    }

    private static Stream<Arguments> provideForFactors() {
        return Stream.of(
            Arguments.of(0L, Set.of()),
            Arguments.of(1L, Set.of(1L)),
            Arguments.of(20L, Set.of(1L, 2L, 4L, 5L, 10L, 20L)),
            Arguments.of(24L, Set.of(1L, 2L, 3L, 4L, 6L, 8L, 12L, 24L)),
            Arguments.of(97L, Set.of(1L, 97L)),
            Arguments.of(99L, Set.of(1L, 3L, 9L, 11L, 33L, 99L)),
            Arguments.of(100L, Set.of(1L, 2L, 4L, 5L, 10L, 20L, 25L, 50L, 100L))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForPrimeFactors")
    void testPrimeFactors(final long input, final Set<Long> expected) {
        final List<Long> output = FactorFinder.primeFactors(input).toList();
        assertThat(output)
            .hasSameElementsAs(expected);
    }

    private static Stream<Arguments> provideForPrimeFactors() {
        return Stream.of(
            Arguments.of(1L, Set.of()),
            Arguments.of(2L, Set.of(2L)),
            Arguments.of(3L, Set.of(3L)),
            Arguments.of(7L, Set.of(7L)),
            Arguments.of(29L, Set.of(29L)),
            Arguments.of(30L, Set.of(2L, 3L, 5L)),
            Arguments.of(4_181L, Set.of(37L, 113L)),
            Arguments.of(13_195L, Set.of(5L, 7L, 13L, 29L)),
            Arguments.of(4_247_083L, Set.of(2_131L, 1_993L))
        );
    }
}
