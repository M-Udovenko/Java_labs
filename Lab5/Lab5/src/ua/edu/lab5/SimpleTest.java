package ua.edu.lab5;

import java.util.Arrays;

public class SimpleTest {
    public static void main(String[] args) {
        testAll();
    }

    public static void testAll() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        assert list.size() == 3 : "add failed";
        assert list.get(0).equals(1) : "add failed";

        Integer old = list.put(1, 10);
        assert old.equals(2) : "put failed";
        assert list.get(1).equals(10) : "put failed";

        assert list.contains(1) : "contains failed";
        assert list.contains(10) : "contains failed";
        assert !list.contains(5) : "contains failed";

        Integer removed = list.remove(1);
        assert removed.equals(10) : "remove by index failed";
        assert list.size() == 2 : "remove by index failed";

        assert list.remove(Integer.valueOf(1)) : "remove by object failed";
        assert list.size() == 1 : "remove by object failed";

        java.util.List<Integer> collection = Arrays.asList(4, 5, 6);
        assert list.addAll(collection) : "addAll failed";
        assert list.size() == 4 : "addAll failed";

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        assert list.size() == 24 : "capacity expansion failed";

        System.out.println("Всі тести пройшли успішно!");
        System.out.println("Кінцевий стан списку: " + list);
    }
}