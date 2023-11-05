package com.fox._3._8;

public class HeapSort {

    public void sort(int[] arr) {
        buildHeap(arr);
        for (int heapSize = arr.length - 1; heapSize > 0; heapSize--) {
            swap(arr, heapSize, 0);
            maxHeapify(arr, 0, heapSize);
        }
    }

    private void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    private void maxHeapify(int[] arr, int rootIndex, int heapSize) {
        int l = left(rootIndex);
        int r = right(rootIndex);
        int largest = rootIndex;
        if (l <= heapSize - 1) {
            if (arr[l] >= arr[largest]) {
                largest = l;
            }
        }
        if (r <= heapSize - 1) {
            if (arr[r] > arr[largest]) {
                largest = r;
            }
        }
        if (largest != rootIndex) {
            swap(arr, rootIndex, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    private int left(int rootIndex) {
        return 2 * rootIndex + 1;
    }

    private int right(int rootIndex) {
        return 2 * rootIndex + 2;
    }

    private void swap(int[] arr, int a, int b) {
        int buffer = arr[a];
        arr[a] = arr[b];
        arr[b] = buffer;
    }
}
