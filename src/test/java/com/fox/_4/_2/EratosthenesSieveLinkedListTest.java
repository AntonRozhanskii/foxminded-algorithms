package com.fox._4._2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class EratosthenesSieveLinkedListTest {

    private final EratosthenesSieve subject = new EratosthenesSieveLinkedList();

    @ParameterizedTest
    @MethodSource("provider")
    void getPrimes(int n, int[] expected) {
        int[] actual = subject.getPrimes(n);
        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> provider() {
        return TestUtils.provider();
    }
}