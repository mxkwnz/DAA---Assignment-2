# Sorting Algorithms - Assignment 2

**Students:**
- Abdullayev Shynggys (Selection Sort)
- Kalen Muhammedali (Insertion Sort)

**Course:** Algorithmic Analysis  
**Assignment:** Algorithm Pairs - Peer Code Review

---

## 📚 Project Overview

This project implements and analyzes two fundamental quadratic sorting algorithms:

1. **Selection Sort** (implemented by Shynggys)
    - Time: O(n²) all cases
    - Space: O(1)
    - Optimization: Early termination on sorted data

2. **Insertion Sort** (implemented by Muhammedali)
    - Time: O(n) best, O(n²) average/worst
    - Space: O(1)
    - Optimization: Binary search for insertion position

---

## 📁 Project Structure

```text
assignment2-sorting-algorithms/
├── src/main/java/
│   ├── algorithms/
│   │   ├── SelectionSort.java      (Shynggys)
│   │   └── InsertionSort.java      (Muhammedali)
│   ├── metrics/
│   │   └── PerformanceTracker.java (Shared)
│   ├── cli/
│   │   ├── SelectionSortBenchmark.java
│   │   ├── InsertionSortBenchmark.java
│   │   └── ComparisonBenchmark.java
│   └── Main.java
├── src/test/java/algorithms/
│   ├── SelectionSortTest.java
│   └── InsertionSortTest.java
├── docs/
│   ├── shynggys/
│   │   ├── analysis-report-insertion-sort.pdf
│   │   └── performance-plots/
│   └── muhammedali/
│       ├── analysis-report-selection-sort.pdf
│       └── performance-plots/
└── pom.xml