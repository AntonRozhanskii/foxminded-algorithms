package com.fox._4._2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EratosthenesSieveLinkedList implements EratosthenesSieve {

    /**
     * This approach either wrong or needs further improvement.
     * The default iterators are fail-fast, what meant they throw an exception,
     * once collection modification noticed.
     * This means I need a custom iterator, ergo a custom collection.
     */
    @Override
    public int[] getPrimes(int n) {
        if (n < 2) {
            return new int[0];
        }
        if (n <= 3) {
            return new int[]{2, 3};
        }
        List<Integer> candidates = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            candidates.add(i + 2);
        }

        int sqrt = (int) Math.sqrt(n);
        Iterator<Integer> mainPointer = candidates.iterator();
        int indexCounter = 0;

        for (int current = mainPointer.next();
             current <= sqrt;
             current = mainPointer.next(),
                     indexCounter++) {
            Iterator<Integer> iterator = candidates.listIterator(indexCounter + 1);
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (next % current == 0) {
                    iterator.remove();
                }
            }
        }

        return candidates.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
