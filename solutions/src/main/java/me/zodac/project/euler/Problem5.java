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

import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;
import me.zodac.project.euler.util.MathUtils;

/**
 * Solution for Problem 5: {@code Smallest Multiple}.
 *
 * @see <a href="https://projecteuler.net/problem=5">Project Euler, Problem 5</a>
 */
public final class Problem5 {

    private Problem5() {

    }

    /**
     * Find the smallest positive number that is evenly divisble by the {@link Long} range defined by {@code start} and {@code end}.
     *
     * @param start the start of the range of {@link Long}s (inclusive)
     * @param end   the end of the range of {@link Long}s (inclusive)
     * @return the smallest common multiple
     * @see MathUtils#lowestCommonMultiple(Collection)
     */
    public static long smallestCommonMultiple(final long start, final long end) {
        final List<Long> range = LongStream.range(start, end + 1).boxed().toList();
        return MathUtils.lowestCommonMultiple(range);
    }
}
