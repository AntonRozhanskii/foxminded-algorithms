package com.fox._4._2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FactorizationAlgorithmTest {

    private final EratosthenesSieve sieve = new EratosthenesSieveArray();
    private final FactorizationAlgorithm algorithm = new FactorizationAlgorithmImpl(sieve);

    @ParameterizedTest
    @MethodSource("provider")
    void factorize(int n, int[] result) {
        assertArrayEquals(result, algorithm.factorize(n));
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(2, new int[]{2}),
                Arguments.of(4, new int[]{2, 2}),
                Arguments.of(9, new int[]{3, 3}),
                Arguments.of(14, new int[]{2, 7}),
                Arguments.of(15, new int[]{3, 5}),
                Arguments.of(25, new int[]{5, 5}),
                Arguments.of(48, new int[]{5, 13}),
                Arguments.of(4200, new int[]{2, 2, 2, 3, 5, 5, 7})
        );
    }
}
