package com.fox._4._3;

import com.fox._4._2.EratosthenesSieve;
import com.fox._4._2.EratosthenesSieveArray;
import com.fox._4._2.FactorizationAlgorithm;
import com.fox._4._2.FactorizationAlgorithmImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GCDTest {

    private final EratosthenesSieve eratosthenesSieve = new EratosthenesSieveArray();
    private final FactorizationAlgorithm factorizationAlgorithm = new FactorizationAlgorithmImpl(eratosthenesSieve);

    private final GCD gcd = new GCD(factorizationAlgorithm);

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