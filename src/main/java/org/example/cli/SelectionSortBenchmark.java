package org.example.cli;

import org.example.algorithms.SelectionSort;

import java.io.FileWriter;
import java.util.Random;

public class SelectionSortBenchmark {
    private static final int[] SIZES = {100, 500, 1000, 5000, 10000};
    private static final int ITERATIONS = 5;

    public static void main(String[] args) throws Exception {
        System.out.println("Selection Sort Benchmark - Shynggys\n");

        FileWriter writer = new FileWriter("src/docs/shynggys/performance-plots/selection_sort_results.csv");
        writer.write("Algorithm,Size,InputType,Comparisons,Swaps,Accesses,Time_ms\n");

        for (int size : SIZES) {
            System.out.printf("Testing size: %,d\n", size);
            testPattern(size, "Random", writer);
            testPattern(size, "Sorted", writer);
            testPattern(size, "Reversed", writer);
            testPattern(size, "NearlySorted", writer);
        }

        writer.close();
        System.out.println("\n✓ Results saved to docs/shynggys/performance-plots/");
    }

    private static void testPattern(int size, String pattern, FileWriter writer) throws Exception {
        SelectionSort sorter = new SelectionSort();
        long totalComp = 0, totalSwaps = 0, totalAccess = 0;
        double totalTime = 0;

        for (int i = 0; i < ITERATIONS; i++) {
            int[] data = generateData(size, pattern, i);
            sorter.getTracker().startTimer();
            sorter.sort(data);
            sorter.getTracker().stopTimer();

            totalComp += sorter.getTracker().getComparisons();
            totalSwaps += sorter.getTracker().getSwaps();
            totalAccess += sorter.getTracker().getArrayAccesses();
            totalTime += sorter.getTracker().getElapsedTimeMs();
        }

        long avgComp = totalComp / ITERATIONS;
        long avgSwaps = totalSwaps / ITERATIONS;
        long avgAccess = totalAccess / ITERATIONS;
        double avgTime = totalTime / ITERATIONS;

        System.out.printf("  %-12s: %,10d comp, %,6d swaps, %.2f ms\n",
                pattern, avgComp, avgSwaps, avgTime);

        writer.write(String.format("SelectionSort,%d,%s,%d,%d,%d,%.6f\n",
                size, pattern, avgComp, avgSwaps, avgAccess, avgTime));
    }

    private static int[] generateData(int size, String pattern, int seed) {
        Random rand = new Random(42 + seed);
        int[] arr = new int[size];

        switch (pattern) {
            case "Random":
                for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
                break;
            case "Sorted":
                for (int i = 0; i < size; i++) arr[i] = i;
                break;
            case "Reversed":
                for (int i = 0; i < size; i++) arr[i] = size - i;
                break;
            case "NearlySorted":
                for (int i = 0; i < size; i++) arr[i] = i;
                int swaps = size / 20;
                for (int i = 0; i < swaps; i++) {
                    int idx1 = rand.nextInt(size);
                    int idx2 = rand.nextInt(size);
                    int temp = arr[idx1];
                    arr[idx1] = arr[idx2];
                    arr[idx2] = temp;
                }
                break;
        }
        return arr;
    }
}