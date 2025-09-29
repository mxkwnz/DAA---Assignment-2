package org.example.metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long arrayAccesses;
    private long startTime;
    private long endTime;

    public PerformanceTracker() {
        reset();
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        startTime = 0;
        endTime = 0;
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public void incrementComparison() {
        comparisons++;
    }

    public void incrementSwap() {
        swaps++;
    }

    public void incrementArrayAccess() {
        arrayAccesses++;
    }

    public void incrementArrayAccess(int count) {
        arrayAccesses += count;
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public double getElapsedTimeMs() {
        return (endTime - startTime) / 1_000_000.0;
    }

    @Override
    public String toString() {
        return String.format(
                "Comparisons: %,d | Swaps: %,d | Accesses: %,d | Time: %.3f ms",
                comparisons, swaps, arrayAccesses, getElapsedTimeMs()
        );
    }

    public String toCSV() {
        return String.format("%d,%d,%d,%.6f",
                comparisons, swaps, arrayAccesses, getElapsedTimeMs()
        );
    }
}
