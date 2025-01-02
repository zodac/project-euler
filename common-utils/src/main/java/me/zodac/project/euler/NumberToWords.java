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

package me.zodac.project.euler;

/**
 * Utility class to convert a number to the written out English representation.
 */
public final class NumberToWords {

    private static final int MAX_VALUE = 9999;
    private static final int THOUSANDS_LIMIT = 1000;
    private static final int THOUSANDS_MOD = 1000;
    private static final int HUNDREDS_IDENTIFIER = 100;
    private static final int HUNDREDS_MOD = 100;
    private static final int TENS_IDENTIFIER = 20; // 11-19 are a special case
    private static final int TENS_MOD = 10;
    private static final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}; // 11-19 are a special case

    private NumberToWords() {

    }

    /**
     * Converts the input to the English representation. For example, the following values will be converted to:
     * <pre>
     *     1 -> "one"
     *     24 -> "twenty-four"
     *     315 -> "three hundred and fifteen
     * </pre>
     *
     * @param input the number to convert, max value of {@value #MAX_VALUE}
     * @return the converted value
     * @throws IllegalArgumentException thrown if the value is out of bounds
     */
    public static String convert(final int input) {
        if (input > MAX_VALUE || input <= 0) {
            throw new IllegalArgumentException(String.format("Expected input between 1 and %s, found: %s", MAX_VALUE, input));
        }

        final StringBuilder stringBuilder = new StringBuilder(18);
        int remaining = input;

        if (remaining >= THOUSANDS_LIMIT) {
            final int numberOfThousands = remaining / THOUSANDS_MOD;
            stringBuilder.append(convert(numberOfThousands)).append(" thousand");

            remaining = remaining % THOUSANDS_MOD;
            if (remaining != 0) {
                stringBuilder.append(' ');
            }
        }

        if (remaining >= HUNDREDS_IDENTIFIER) {
            final int numberOfHundreds = remaining / HUNDREDS_MOD;
            stringBuilder.append(convert(numberOfHundreds)).append(" hundred");

            remaining = remaining % HUNDREDS_MOD;
            if (remaining != 0) {
                stringBuilder.append(" and ");
            }
        }

        if (remaining >= TENS_IDENTIFIER) {
            final int numberOfTens = remaining / TENS_MOD;
            stringBuilder.append(TENS[numberOfTens]);

            remaining = remaining % TENS_MOD;
            if (remaining != 0) {
                stringBuilder.append('-');
            }
        }

        stringBuilder.append(UNITS[remaining]);
        return stringBuilder.toString();
    }
}
