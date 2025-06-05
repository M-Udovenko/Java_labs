package ua.edu.lab5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестування ArrayList");

        ArrayList<String> list = new ArrayList<>();

        System.out.println("\n1. Додавання елементів:");
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Список: " + list);
        System.out.println("Розмір: " + list.size());

        System.out.println("\n2. Заміна елемента:");
        String old = list.put(1, "X");
        System.out.println("Замінили '" + old + "' на 'X'");
        System.out.println("Список: " + list);

        System.out.println("\n3. Додавання колекції:");
        java.util.List<String> collection = Arrays.asList("D", "E", "F");
        list.addAll(collection);
        System.out.println("Список: " + list);

        System.out.println("\n4. Перевірка наявності:");
        System.out.println("Містить 'A': " + list.contains("A"));
        System.out.println("Містить 'Z': " + list.contains("Z"));

        System.out.println("\n5. Видалення:");
        System.out.println("Видаляємо 'X': " + list.remove("X"));
        System.out.println("Видаляємо елемент з індексу 2: " + list.remove(2));
        System.out.println("Список: " + list);

        System.out.println("\n6. Тестування розширення ємності:");
        ArrayList<Integer> numbers = new ArrayList<>(5);
        for (int i = 1; i <= 12; i++) {
            numbers.add(i);
        }
        System.out.println("Додали 12 елементів: " + numbers);

        System.out.println("\nТестування завершено");
    }
}