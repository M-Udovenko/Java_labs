package ua.edu.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedDequeTest {

    private LinkedDeque<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new LinkedDeque<>();
    }

    @Test
    void testAddFirst() {
        deque.addFirst(1);
        assertEquals(1, deque.getFirst());
        assertEquals(1, deque.size());

        deque.addFirst(2);
        assertEquals(2, deque.getFirst());
        assertEquals(1, deque.getLast());
        assertEquals(2, deque.size());
    }

    @Test
    void testAddLast() {
        deque.addLast(1);
        assertEquals(1, deque.getLast());
        assertEquals(1, deque.size());

        deque.addLast(2);
        assertEquals(2, deque.getLast());
        assertEquals(1, deque.getFirst());
        assertEquals(2, deque.size());
    }

    @Test
    void testRemoveFirst() {
        deque.addFirst(1);
        deque.addFirst(2);

        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals(1, deque.getFirst());

        assertEquals(1, deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    void testRemoveLast() {
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals(1, deque.getLast());

        assertEquals(1, deque.removeLast());
        assertEquals(0, deque.size());
    }

    @Test
    void testGetFirstEmptyDeque() {
        assertThrows(NoSuchElementException.class, () -> deque.getFirst());
    }

    @Test
    void testGetLastEmptyDeque() {
        assertThrows(NoSuchElementException.class, () -> deque.getLast());
    }

    @Test
    void testRemoveFirstEmptyDeque() {
        assertThrows(NoSuchElementException.class, () -> deque.removeFirst());
    }

    @Test
    void testRemoveLastEmptyDeque() {
        assertThrows(NoSuchElementException.class, () -> deque.removeLast());
    }

    @Test
    void testAddAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(deque.addAll(list));
        assertEquals(3, deque.size());
        assertEquals(1, deque.getFirst());
        assertEquals(3, deque.getLast());

        List<Integer> emptyList = new ArrayList<>();
        assertFalse(deque.addAll(emptyList));
        assertEquals(3, deque.size());
    }

    @Test
    void testRemove() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(2);

        assertTrue(deque.remove(2));
        assertEquals(3, deque.size());
        assertTrue(deque.contains(2)); //

        assertFalse(deque.remove(5));
        assertEquals(3, deque.size());

        // Тест удаления null
        deque.addLast(null);
        assertTrue(deque.remove(null));
        assertEquals(3, deque.size());
    }

    @Test
    void testContains() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(null);

        assertTrue(deque.contains(1));
        assertTrue(deque.contains(2));
        assertTrue(deque.contains(null));
        assertFalse(deque.contains(3));
    }

    @Test
    void testSize() {
        assertEquals(0, deque.size());

        deque.addFirst(1);
        assertEquals(1, deque.size());

        deque.addLast(2);
        assertEquals(2, deque.size());

        deque.removeFirst();
        assertEquals(1, deque.size());

        deque.removeLast();
        assertEquals(0, deque.size());
    }

    @Test
    void testComplexOperations() {
        // Сложный сценарий
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);
        deque.addLast(4);

        // Порядок: 1, 2, 3, 4
        assertEquals(4, deque.size());
        assertEquals(1, deque.getFirst());
        assertEquals(4, deque.getLast());

        assertEquals(1, deque.removeFirst());
        assertEquals(4, deque.removeLast());
        assertEquals(2, deque.size());
        assertEquals(2, deque.getFirst());
        assertEquals(3, deque.getLast());
    }

    @Test
    void testSingleElement() {
        deque.addFirst(42);

        assertEquals(42, deque.getFirst());
        assertEquals(42, deque.getLast());
        assertEquals(1, deque.size());
        assertTrue(deque.contains(42));

        assertEquals(42, deque.removeFirst());
        assertEquals(0, deque.size());
    }
}