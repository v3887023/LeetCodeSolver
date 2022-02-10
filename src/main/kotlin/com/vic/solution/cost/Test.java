package com.vic.solution.cost;

public class Test {
    public static void main(String[] args) {
        runCost(() -> {
            int[] array = new int[100_0000];
            for (int i = 0, size = array.length; i < size; i++) {
                array[i] = i;
            }

            int sum = 0;
            for (int value : array) {
                sum += value;
            }
        });

        runCost(() -> {
            Integer[] array = new Integer[100_0000];
            for (int i = 0, size = array.length; i < size; i++) {
                array[i] = i;
            }

            Integer sum = 0;
            for (Integer integer : array) {
                sum += integer;
            }
        });
    }

    private static void runCost(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long cost = System.currentTimeMillis() - start;

        System.out.println("cost " + cost + "ms");
    }
}
