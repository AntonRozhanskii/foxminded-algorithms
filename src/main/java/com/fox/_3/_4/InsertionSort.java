package com.fox._3._4;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] array) {
        System.out.println("Initial array: " + Arrays.toString(array));
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int index = i + 1;
            System.out.println("i=" + index);
            System.out.print("  array[" + index + "]=" + array[i]);
            if (array[i] < array[i - 1]) {
                System.out.println(" is less than array[" + (index - 1) + "]=" + array[i - 1] + ". Will find the right place:");
                boolean isSwapNeeded = true;
                for (int j = i; j > 0 && isSwapNeeded; j--) {
                    if (array[j] < array[j - 1]) {
                        System.out.println("    Replacing array[" + (j + 1) + "]=" + array[j] + " and array[" + j + "]=" + array[j - 1]);
                        int buffer = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = buffer;
                    } else {
                        System.out.println("    Array[" + (j + 1) +"]=" +array[j] + " and array[" + j + "]="+array[j - 1]+". No swap needed. Can proceed with the next index.");
                        isSwapNeeded = false;
                    }
                }
            } else {
                System.out.println(" is greater or equals array[" + (index - 1) + "]=" + array[i - 1] + ". No action needed.");
            }
            System.out.println("Now array looks like: " + Arrays.toString(array));
        }
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
