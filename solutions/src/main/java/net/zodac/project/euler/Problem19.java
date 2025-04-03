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

package net.zodac.project.euler;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Solution for Problem 19: {@code Counting Sundays}.
 *
 * @see <a href="https://projecteuler.net/problem=19">Project Euler, Problem 19</a>
 */
public final class Problem19 {

    private Problem19() {

    }

    /**
     * Counts the number of months, where the first day of the month is a {@link DayOfWeek#SUNDAY}, given the specified time window.
     *
     * @param start the start {@link LocalDate} (inclusive)
     * @param end   the end {@link LocalDate} (inclusive)
     * @return the number of months starting with {@link DayOfWeek#SUNDAY}
     */
    public static long countMonthsStartingWithSunday(final LocalDate start, final LocalDate end) {
        int count = 0;

        for (int year = start.getYear(); year <= end.getYear(); year++) {
            for (int month = start.getMonthValue(); month <= end.getMonthValue(); month++) {
                final LocalDate date = LocalDate.of(year, month, 1);
                if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    count++;
                }
            }
        }

        return count;
    }
}
