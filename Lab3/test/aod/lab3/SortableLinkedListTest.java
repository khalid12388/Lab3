package aod.lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortableLinkedListTest {

    private SortableLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SortableLinkedList<>();

        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
    }

    @Test
    void testSize() {
        assertEquals(5, list.size());
    }

    @Test
    void testBubbleSort() {
        SortableList<Integer> sorted = list.bubbelSort();

        assertEquals(1, sorted.get(0));
        assertEquals(5, sorted.get(4));
    }

    @Test
    void testInsertionSort() {
        SortableList<Integer> sorted = list.insertionSort();

        assertEquals(1, sorted.get(0));
        assertEquals(5, sorted.get(4));
    }

    @Test
    void testMergeSort() {
        SortableList<Integer> sorted = list.mergeSort();

        assertEquals(1, sorted.get(0));
        assertEquals(5, sorted.get(4));
    }

    @Test
    void testQuickSort() {
        SortableList<Integer> sorted = list.quickSort();

        assertEquals(1, sorted.get(0));
        assertEquals(5, sorted.get(4));
    }

    @Test
    void testOriginalListUnchanged() {
        list.bubbelSort();

        assertEquals(5, list.get(0));
        assertEquals(3, list.get(1));
    }
}