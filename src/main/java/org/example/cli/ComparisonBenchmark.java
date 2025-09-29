package org.example.cli;

import org.example.algorithms.SelectionSort;
import org.example.algorithms.InsertionSort;
import java.util.Random;

public class ComparisonBenchmark {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║    Selection Sort vs Insertion Sort Comparison   ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        int[] sizes = {100, 1000, 5000};

        for (int size : sizes) {
            System.out.println("\nSize: " + size);
            System.out.println("─".repeat(50));

            testComparison(size, "Random");
            testComparison(size, "Sorted");
            testComparison(size, "Reversed");
        }
    }

    private static void testComparison(int size, String type) {
        int[] data1 = generateData(size, type);
        int[] data2 = data1.clone();

        SelectionSort selSort = new SelectionSort();
        InsertionSort insSort = new InsertionSort();

        selSort.getTracker().startTimer();
        selSort.sort(data1);
        selSort.getTracker().stopTimer();

        insSort.getTracker().startTimer();
        insSort.sort(data2);
        insSort.getTracker().stopTimer();

        System.out.printf("%-12s: Selection=%.2fms, Insertion=%.2fms | Winner: %s\n",
                type,
                selSort.getTracker().getElapsedTimeMs(),
                insSort.getTracker().getElapsedTimeMs(),
                selSort.getTracker().getElapsedTimeMs() < insSort.getTracker().getElapsedTimeMs()
                        ? "Selection" : "Insertion"
        );
    }

    private static int[] generateData(int size, String type) {
        Random rand = new Random(42);
        int[] arr = new int[size];

        switch (type) {
            case "Random":
                for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
                break;
            case "Sorted":
                for (int i = 0; i < size; i++) arr[i] = i;
                break;
            case "Reversed":
                for (int i = 0; i < size; i++) arr[i] = size - i;
                break;
        }
        return arr;
    }
}