package algorithms;

import org.example.algorithms.SelectionSort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    private SelectionSort sorter;

    @BeforeEach
    void setUp() {
        sorter = new SelectionSort();
    }

    @Test
    void testEmpty() {
        int[] arr = {};
        sorter.sort(arr);
        assertEquals(0, arr.length);
    }

    @Test
    void testSingle() {
        int[] arr = {5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testSorted() {
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReversed() {
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testRandom() {
        int[] arr = {3, 7, 1, 9, 2};
        sorter.sort(arr);
        assertTrue(SelectionSort.isSorted(arr));
    }

    @Test
    void testDuplicates() {
        int[] arr = {5, 2, 5, 1, 2};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 2, 5, 5}, arr);
    }

    @Test
    void testNegative() {
        int[] arr = {-3, 5, -1, 0};
        sorter.sort(arr);
        assertArrayEquals(new int[]{-3, -1, 0, 5}, arr);
    }

    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class, () -> sorter.sort(null));
    }
}