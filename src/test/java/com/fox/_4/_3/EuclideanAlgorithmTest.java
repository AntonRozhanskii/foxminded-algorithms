package com.fox._4._3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EuclideanAlgorithmTest {

    private final EuclideanAlgorithm gcd = new EuclideanAlgorithm();

    @ParameterizedTest
    @MethodSource("provider")
    void find(int a, int b, int expectedGcd) {
        assertEquals(expectedGcd, gcd.find(a, b));
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(15, 14, 1),
                Arguments.of(100, 0, 100),
                Arguments.of(700, 700, 700),
                Arguments.of(2, 3, 1),
                Arguments.of(9, 12, 3)
        );
    }
}