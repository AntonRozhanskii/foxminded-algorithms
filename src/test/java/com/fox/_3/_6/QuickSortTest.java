package com.fox._3._6;

import com.fox._3.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private final QuickSort hoareSort = new QuickSort(QuickSort.Type.HOARE);
    private final QuickSort lomutoSort = new QuickSort(QuickSort.Type.LOMUTO);


    @Test
    void test() {
        Random random = new Random();
        int length = 6;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(14);
            arr[i] = rand;
        }
        System.out.println(Arrays.toString(arr));
    }

    @ParameterizedTest
    @MethodSource("provider")
    void hoareSort(int[] initial, int[] expected) {
        hoareSort.sort(initial);

        assertArrayEquals(expected, initial);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void lomutoSort(int[] initial, int[] expected) {
        lomutoSort.sort(initial);

        assertArrayEquals(expected, initial);
    }

    private static Stream<Arguments> provider() {
        return TestUtils.provider();
    }
}