package aod.lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

/**
 * Klass för att testa funktionaliteten i LinkedList med hjälp av JUnit-tester.
 *
 * @author Khalid Abdi Hashi
 * @date 2026-04-10
 */
public class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    // Testar add(T data)
    @Test
    void testAddToEmptyList() {
        list.add(10);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testAddSeveralElements() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    // Testar add(T data, int index)
    @Test
    void testAddAtIndexZero() {
        list.add(2);
        list.add(3);
        list.add(1, 0);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testAddAtMiddle() {
        list.add(1);
        list.add(3);
        list.add(2, 1);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    // Testar get(int index)
    @Test
    void testGetWorks() {
        list.add(5);
        list.add(10);

        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    void testGetThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    // Testar set(T data, int index)
    @Test
    void testSetChangesValue() {
        list.add(1);
        list.add(2);

        list.set(99, 1);

        assertEquals(99, list.get(1));
    }

    @Test
    void testSetThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, 0));

        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, 2));
    }

    // Testar remove()
    @Test
    void testRemoveLast() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove();

        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    // Testar remove(int index)
    @Test
    void testRemoveIndexZero() {
        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(0);

        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void testRemoveMiddle() {
        list.add(10);
        list.add(20);
        list.add(30);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void testRemoveThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove());

        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    // Testar size()
    @Test
    void testSizeEmptyList() {
        assertEquals(0, list.size());
    }

    @Test
    void testSizeAfterAddAndRemove() {
        list.add(1);
        list.add(2);
        list.remove();

        assertEquals(1, list.size());
    }

    // Testar clear()
    @Test
    void testClearRemovesEverything() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    void testClearEmptyList() {
        list.clear();

        assertEquals(0, list.size());
    }

    // Testar iterator
    @Test
    void testIteratorHasNext() {
        list.add(1);
        list.add(2);

        Iterator<Integer> it = list.iterator();

        assertTrue(it.hasNext());
    }

    @Test
    void testIteratorNext() {
        list.add(5);
        list.add(10);

        Iterator<Integer> it = list.iterator();

        assertEquals(5, it.next());
        assertEquals(10, it.next());
    }

    @Test
    void testForEachLoop() {
        list.add(1);
        list.add(2);
        list.add(3);

        int sum = 0;

        for (int number : list) {
            sum += number;
        }

        assertEquals(6, sum);
    }
}