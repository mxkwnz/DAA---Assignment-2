package org.example.algorithms;

import org.example.metrics.PerformanceTracker;

public class InsertionSort {
    private PerformanceTracker tracker;

    public InsertionSort() {
        this.tracker = new PerformanceTracker();
    }

    public void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length <= 1) return;

        tracker.reset();

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            tracker.incrementArrayAccess();

            tracker.incrementComparison();
            tracker.incrementArrayAccess();

            if (key >= arr[i - 1]) {
                continue;
            }

            int insertPos = binarySearchPosition(arr, 0, i - 1, key);

            for (int j = i - 1; j >= insertPos; j--) {
                arr[j + 1] = arr[j];
                tracker.incrementSwap();
                tracker.incrementArrayAccess(2);
            }

            arr[insertPos] = key;
            tracker.incrementArrayAccess();
        }
    }

    private int binarySearchPosition(int[] arr, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            tracker.incrementComparison();
            tracker.incrementArrayAccess();

            if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
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