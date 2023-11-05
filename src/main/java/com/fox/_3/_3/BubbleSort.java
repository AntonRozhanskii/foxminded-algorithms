package com.fox._3._3;

public class BubbleSort {

    public void sort(int[] array) {
        int length = array.length;
        for (int j = length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int buffer = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buffer;
                }
            }
        }
    }
}
