package org.example.algorithms;

import org.example.metrics.PerformanceTracker;

public class SelectionSort {
    private PerformanceTracker tracker;

    public SelectionSort() {
        this.tracker = new PerformanceTracker();
    }

    public void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length <= 1) return;

        tracker.reset();

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            boolean remainingSorted = true;

            tracker.incrementArrayAccess();

            for (int j = i + 1; j < arr.length; j++) {
                tracker.incrementComparison();
                tracker.incrementArrayAccess(2);

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    remainingSorted = false;
                }

                if (j > i + 1) {
                    tracker.incrementComparison();
                    tracker.incrementArrayAccess(2);
                    if (arr[j] < arr[j - 1]) {
                        remainingSorted = false;
                    }
                }
            }

            if (remainingSorted && minIndex == i) {
                break;
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        tracker.incrementSwap();
        tracker.incrementArrayAccess(4);
    }

    public PerformanceTracker getTracker() {
        return tracker;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}