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

package me.zodac.project.euler.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for {@link StringUtils}.
 */
class StringUtilsTest {

    @ParameterizedTest
    @CsvSource({
        "a,true",       // Single character
        "aba,true",     // Palindrome (odd length)
        "abba,true",    // Palindrome (even length)
        "aaa,true",     // Palindrome (all same characters)
        "abc,false",    // Not a palindrome
        "'',true",      // Empty
        "' ',true",     // Blank
    })
    void testIsPalindrome(final String input, final boolean expected) {
        final boolean output = StringUtils.isPalindrome(input);
        assertThat(output)
            .isEqualTo(expected);
    }
}
