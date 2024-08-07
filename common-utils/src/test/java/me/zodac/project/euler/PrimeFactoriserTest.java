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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link PrimeFactoriser}.
 */
class PrimeFactoriserTest {

    @ParameterizedTest
    @MethodSource("provideForPrimeFactors")
    void testPrimeFactors(final long input, final Set<Long> expected) {
        final List<Long> output = PrimeFactoriser.primeFactors(input).toList();
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
