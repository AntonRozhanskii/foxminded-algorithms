package com.fox._4._3;

import com.fox._4._2.FactorizationAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class GCD {

    private final FactorizationAlgorithm factorizationAlgorithm;

    public GCD(FactorizationAlgorithm factorizationAlgorithm) {
        this.factorizationAlgorithm = factorizationAlgorithm;
    }

    public int find(int a, int b) {
        int[] aDividers = factorizationAlgorithm.factorize(a);
        int[] bDividers = factorizationAlgorithm.factorize(b);

        List<Integer> commonPrimes = new ArrayList<>();

        int i = 0, j = 0;
        while ((i < aDividers.length - 1) || (j < bDividers.length - 1)) {
            if (aDividers[i] == bDividers[j]) {
                commonPrimes.add(aDividers[i]);
                i++;
                j++;
            } else {
                if (aDividers[i] > bDividers[j]) {
                    j++;
                }
                if (aDividers[i] < bDividers[j]) {
                    i++;
                }
            }
        }
        return commonPrimes.stream()
                .reduce(1, (e1, e2) -> e1 * e2);
    }
}
