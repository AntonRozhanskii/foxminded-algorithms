package com.fox._4._3;

public class EuclideanAlgorithm {

    public int find(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if (min == 0) {
            return max;
        }

        while (min != 0) {
            int buffer = max % min;
            max = min;
            min = buffer;
        }
        return max;
    }
}
