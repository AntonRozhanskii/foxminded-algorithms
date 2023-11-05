package com.fox._3;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public final class TestUtils {

    private TestUtils() {}

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{2, 2, 2}, new int[]{2, 2, 2}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1, 2, 3}, new int[]{1, 2, 2, 3, 3}),
                Arguments.of(new int[]{31, 22, 16, 22, 31}, new int[]{16, 22, 22, 31, 31}),
                Arguments.of(new int[]{12, 0, 8, 7, 9, 10}, new int[]{0, 7, 8, 9, 10, 12}),
                Arguments.of(new int[]{12, 0, 8, 7, 0, 4}, new int[]{0, 0, 4, 7, 8, 12}),
                Arguments.of(new int[]{12, 13, 8, 7, 0, 4}, new int[]{0, 4, 7, 8, 12, 13})
        );
    }
}
