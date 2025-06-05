package ua.edu.lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    private ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(0, list.size());
    }

    @Test
    void testConstructorWithCapacity() {
        ArrayList<String> listWithCapacity = new ArrayList<>(20);
        assertEquals(0, listWithCapacity.size());
    }

    @Test
    void testConstructorWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<String>(-1));
    }

    @Test
    void testAdd() {
        list.add(1);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));

        list.add(2);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test
    void testAddNull() {
        list.add(null);
        assertEquals(1, list.size());
        assertNull(list.get(0));
    }

    @Test
    void testAddManyElements() {
        // Тестуємо розширення масиву
        for (int i = 0; i < 25; i++) {
            list.add(i);
        }
        assertEquals(25, list.size());
        assertEquals(Integer.valueOf(24), list.get(24));
    }

    @Test
    void testPut() {
        list.add(1);
        list.add(2);

        Integer old = list.put(0, 10);
        assertEquals(Integer.valueOf(1), old);
        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(2, list.size()); // розмір не змінюється
    }

    @Test
    void testPutInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.put(0, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.put(-1, 1));

        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.put(1, 2));
    }

    @Test
    void testPutNull() {
        list.add(1);
        Integer old = list.put(0, null);
        assertEquals(Integer.valueOf(1), old);
        assertNull(list.get(0));
    }

    @Test
    void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        Integer removed = list.remove(1);
        assertEquals(Integer.valueOf(2), removed);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    void testRemoveFirstElement() {
        list.add(1);
        list.add(2);

        Integer removed = list.remove(0);
        assertEquals(Integer.valueOf(1), removed);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(2), list.get(0));
    }

    @Test
    void testRemoveLastElement() {
        list.add(1);
        list.add(2);

        Integer removed = list.remove(1);
        assertEquals(Integer.valueOf(2), removed);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    void testRemoveInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));

        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testRemoveByObject() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.remove(Integer.valueOf(2)));
        assertEquals(2, list.size());
        assertFalse(list.contains(2));
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    void testRemoveNonExistentObject() {
        list.add(1);
        list.add(2);

        assertFalse(list.remove(Integer.valueOf(5)));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveNull() {
        list.add(1);
        list.add(null);
        list.add(2);

        assertTrue(list.remove(null));
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test
    void testRemoveFromEmptyList() {
        assertFalse(list.remove(Integer.valueOf(1)));
    }

    @Test
    void testAddAll() {
        java.util.List<Integer> collection = Arrays.asList(1, 2, 3);
        assertTrue(list.addAll(collection));
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    void testAddAllEmpty() {
        assertFalse(list.addAll(Collections.emptyList()));
        assertEquals(0, list.size());
    }

    @Test
    void testAddAllNull() {
        assertFalse(list.addAll(null));
        assertEquals(0, list.size());
    }

    @Test
    void testAddAllToNonEmptyList() {
        list.add(0);
        java.util.List<Integer> collection = Arrays.asList(1, 2);
        assertTrue(list.addAll(collection));
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(0), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));
    }

    @Test
    void testContains() {
        list.add(1);
        list.add(2);
        list.add(null);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(null));
        assertFalse(list.contains(3));
    }

    @Test
    void testContainsEmptyList() {
        assertFalse(list.contains(1));
        assertFalse(list.contains(null));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.add(2);
        assertEquals(2, list.size());

        list.remove(0);
        assertEquals(1, list.size());

        list.remove(Integer.valueOf(2));
        assertEquals(0, list.size());
    }

    @Test
    void testGet() {
        list.add(1);
        list.add(2);

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test
    void testGetInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));

        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void testToString() {
        assertEquals("[]", list.toString());

        list.add(1);
        assertEquals("[1]", list.toString());

        list.add(2);
        list.add(3);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    void testToStringWithNull() {
        list.add(1);
        list.add(null);
        list.add(2);
        assertEquals("[1, null, 2]", list.toString());
    }

    // Інтеграційні тести
    @Test
    void testComplexOperations() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.put(1, 20);
        assertTrue(list.contains(20));
        assertFalse(list.contains(2));

        list.remove(Integer.valueOf(20));
        assertEquals(2, list.size());

        java.util.List<Integer> toAdd = Arrays.asList(4, 5);
        list.addAll(toAdd);
        assertEquals(4, list.size());

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(4), list.get(2));
        assertEquals(Integer.valueOf(5), list.get(3));
    }

    @Test
    void testCapacityExpansion() {
        ArrayList<Integer> smallList = new ArrayList<>(2);

        for (int i = 0; i < 10; i++) {
            smallList.add(i);
        }

        assertEquals(10, smallList.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), smallList.get(i));
        }
    }
}