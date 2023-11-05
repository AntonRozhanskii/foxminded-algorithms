package com.fox._3._6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuickSort {

    private final Random random = new Random();

    private final Map<Type, QuickSortAlgorithm> ALGORITHM_MAP = new HashMap<>() {{
        put(Type.HOARE, QuickSort.this::hoare);
        put(Type.LOMUTO, QuickSort.this::lomuto);
    }};
    private final Type type;

    public QuickSort(Type type) {
        this.type = type;
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    public enum Type {
        HOARE,
        LOMUTO;
    }

    private interface QuickSortAlgorithm {

        int sort(int[] arr, int low, int high);
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = ALGORITHM_MAP.get(type).sort(arr, low, high);
        sort(arr, low, pivotIndex);
        sort(arr, pivotIndex + 1, high);
    }

    private int hoare(int[] arr, int low, int high) {
        int pivotIndex = random.nextInt(high + 1 - low) + low;
        int pivot = arr[pivotIndex];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int buffer = arr[i];
                arr[i] = arr[j];
                arr[j] = buffer;
                i++;
                j--;
            }
        }
        return j;
    }

    private int lomuto(int[] arr, int low, int high) {
        int pivotIndex = random.nextInt(high - low + 1) + low;
        {
            int buffer = arr[high];
            arr[high] = arr[pivotIndex];
            arr[pivotIndex] = buffer;
        }
        int pivot = arr[high];
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                int buffer = arr[j];
                arr[j] = arr[i];
                arr[i] = buffer;
                i++;
            }
        }
        {
            int buffer = arr[i];
            arr[i] = arr[high];
            arr[high] = buffer;
        }
        return i - 1; // Subtract 1 for compatibility with HOARE partition
    }
}


