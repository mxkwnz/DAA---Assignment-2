package org.example;

import org.example.algorithms.InsertionSort;
import org.example.algorithms.SelectionSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║        Sorting Algorithms - Interactive Demo       ║");
        System.out.println("║   Selection Sort (Shynggys) vs Insertion Sort (Muhammedali) ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        while (true) {
            displayMenu();
            System.out.print("Choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) break;

            System.out.print("\nEnter numbers (space-separated): ");
            String input = scanner.nextLine();
            String[] parts = input.split("\\s+");

            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            switch (choice) {
                case 1 -> sortWithSelection(arr);
                case 2 -> sortWithInsertion(arr);
                case 3 -> compareBoth(arr);
                case 4 -> showExamples();
            }
        }

        scanner.close();
        System.out.println("\nGoodbye!");
    }

    private static void displayMenu() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("MENU:");
        System.out.println("1. Sort with Selection Sort (Shynggys)");
        System.out.println("2. Sort with Insertion Sort (Muhammedali)");
        System.out.println("3. Compare both algorithms");
        System.out.println("4. Show example demonstrations");
        System.out.println("5. Exit");
        System.out.println("─".repeat(50));
    }

    private static void sortWithSelection(int[] arr) {
        System.out.println("\n📥 Before: " + Arrays.toString(arr));

        SelectionSort sorter = new SelectionSort();
        sorter.getTracker().startTimer();
        sorter.sort(arr);
        sorter.getTracker().stopTimer();

        System.out.println("📤 After:  " + Arrays.toString(arr));
        System.out.println("📊 " + sorter.getTracker());
    }

    private static void sortWithInsertion(int[] arr) {
        System.out.println("\n📥 Before: " + Arrays.toString(arr));

        InsertionSort sorter = new InsertionSort();
        sorter.getTracker().startTimer();
        sorter.sort(arr);
        sorter.getTracker().stopTimer();

        System.out.println("📤 After:  " + Arrays.toString(arr));
        System.out.println("📊 " + sorter.getTracker());
    }

    private static void compareBoth(int[] arr) {
        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone();

        System.out.println("\n📥 Input: " + Arrays.toString(arr));

        SelectionSort selSort = new SelectionSort();
        selSort.getTracker().startTimer();
        selSort.sort(arr1);
        selSort.getTracker().stopTimer();

        InsertionSort insSort = new InsertionSort();
        insSort.getTracker().startTimer();
        insSort.sort(arr2);
        insSort.getTracker().stopTimer();

        System.out.println("\n🔵 Selection Sort (Shynggys):");
        System.out.println("   Result: " + Arrays.toString(arr1));
        System.out.println("   " + selSort.getTracker());

        System.out.println("\n🟢 Insertion Sort (Muhammedali):");
        System.out.println("   Result: " + Arrays.toString(arr2));
        System.out.println("   " + insSort.getTracker());

        double selTime = selSort.getTracker().getElapsedTimeMs();
        double insTime = insSort.getTracker().getElapsedTimeMs();

        System.out.println("\n🏆 Winner: " +
                (selTime < insTime ? "Selection Sort" : "Insertion Sort") +
                String.format(" (%.3f ms vs %.3f ms)", selTime, insTime));
    }

    private static void showExamples() {
        System.out.println("\n🎯 EXAMPLE DEMONSTRATIONS\n");

        System.out.println("Example 1: Random Array");
        compareBoth(new int[]{64, 25, 12, 22, 11});

        System.out.println("\n" + "─".repeat(50));
        System.out.println("\nExample 2: Already Sorted");
        compareBoth(new int[]{1, 2, 3, 4, 5});

        System.out.println("\n" + "─".repeat(50));
        System.out.println("\nExample 3: Reverse Sorted");
        compareBoth(new int[]{5, 4, 3, 2, 1});
    }
}