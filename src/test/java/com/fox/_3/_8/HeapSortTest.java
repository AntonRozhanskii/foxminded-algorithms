package com.fox._3._8;

import com.fox._3.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {

    private final HeapSort sort = new HeapSort();

    @ParameterizedTest
    @MethodSource("provider")
    void sort(int[] initial, int[] expected) {
        sort.sort(initial);

        assertArrayEquals(expected, initial);
    }

    private static Stream<Arguments> provider() {
        return TestUtils.provider();
    }
}