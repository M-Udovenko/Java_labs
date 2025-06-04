package ua.edu.lab4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестування LinkedDeque");

        LinkedDeque<String> deque = new LinkedDeque<>();

        System.out.println("\n1. Додавання елементів:");
        deque.addFirst("B");
        deque.addLast("C");
        deque.addFirst("A");
        deque.addLast("D");

        System.out.println("Розмір: " + deque.size());
        System.out.println("Перший: " + deque.getFirst());
        System.out.println("Останній: " + deque.getLast());

        System.out.println("\n2. Додавання колекції:");
        List<String> list = new ArrayList<>();
        list.add("E");
        list.add("F");
        deque.addAll(list);
        System.out.println("Розмір після addAll: " + deque.size());

        System.out.println("\n3. Перевірка наявності:");
        System.out.println("Містить 'A': " + deque.contains("A"));
        System.out.println("Містить 'Z': " + deque.contains("Z"));

        System.out.println("\n4. Видалення елемента:");
        System.out.println("Видаляємо 'C': " + deque.remove("C"));
        System.out.println("Розмір після видалення: " + deque.size());

        System.out.println("\n5. Видалення з кінців:");
        while (deque.size() > 0) {
            System.out.println("Видаляємо перший: " + deque.removeFirst());
        }

        System.out.println("Кінцевий розмір: " + deque.size());
        System.out.println("\nТестування завершено");
    }
}