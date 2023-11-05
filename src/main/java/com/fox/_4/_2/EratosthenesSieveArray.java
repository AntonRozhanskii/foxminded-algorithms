package com.fox._4._2;

public class EratosthenesSieveArray implements EratosthenesSieve {

    @Override
    public int[] getPrimes(int n) {
        if (n < 2) {
            return new int[0];
        }
        if (n == 2) {
            return new int[]{2};
        }
        boolean[] candidates = new boolean[n];
        int primeCounter = 0;
        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= n; i++) {
            if (!candidates[i - 2]) {
                primeCounter++;
                if (i <= sqrt) {
                    for (int j = i; i * j <= n; j++) {
                        candidates[i * j - 2] = true;
                    }
                }
            }
        }

        int[] primes = new int[primeCounter];
        for (int i = 0, j = 0; i < candidates.length - 1 && j <= primeCounter; i++) {
            if (!candidates[i]) {
                primes[j++] = i + 2;
            }
        }
        return primes;
    }
}
