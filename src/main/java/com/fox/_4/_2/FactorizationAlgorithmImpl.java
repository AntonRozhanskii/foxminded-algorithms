package com.fox._4._2;

import java.util.ArrayList;
import java.util.List;

public class FactorizationAlgorithmImpl implements FactorizationAlgorithm {

    private final EratosthenesSieve eratosthenesSieve;

    public FactorizationAlgorithmImpl(EratosthenesSieve eratosthenesSieve) {
        this.eratosthenesSieve = eratosthenesSieve;
    }

    @Override
    public int[] factorize(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n <= 3) {
            return new int[]{n};
        }
        int[] primes = eratosthenesSieve.getPrimes((int) Math.sqrt(n));

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= primes.length - 1 && n > 1; ) {
            if (n % primes[i] == 0) {
                n /= primes[i];
                result.add(primes[i]);
            } else {
                i++;
            }
        }

        if (n > 1) {
            result.add(n);
        }

        System.out.println(result);

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
