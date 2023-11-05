package com.fox._4._2;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

final class TestUtils {

    private TestUtils() {}

    public static Stream<Arguments> provider(){
        return Stream.of(
                Arguments.of(1, new int[0]),
                Arguments.of(3, new int[]{2, 3}),
                Arguments.of(4, new int[]{2, 3}),
                Arguments.of(25, new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23}),
                Arguments.of(120, new int[]{
                        2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                        31, 37, 41, 43, 47, 53, 59, 61, 67,
                        71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113
                })
        );
    }
}
