import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість коней: ");
        int horseCount = scanner.nextInt();

        System.out.print("Введіть довжину іподрому: ");
        int distance = scanner.nextInt();

        System.out.print("На якого коня ставите (номер від 1 до " + horseCount + "): ");
        int betHorse = scanner.nextInt() - 1;

        System.out.print("Виберіть реалізацію (1 - Thread, 2 - ExecutorService): ");
        int implementation = scanner.nextInt();

        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < horseCount; i++) {
            horses.add(new Horse("Кінь-" + (i + 1)));
        }

        System.out.println("\nІнформація про коней:");
        for (int i = 0; i < horses.size(); i++) {
            System.out.println((i + 1) + ". " + horses.get(i).getName() +
                    " (швидкість: " + horses.get(i).getSpeed() + ")");
        }

        System.out.println("\nПочинаються скачки!");

        List<Horse> results;
        if (implementation == 1) {
            HippodromeThread hippodrome = new HippodromeThread();
            results = hippodrome.startRace(horses, distance);
        } else {
            HippodromeExecutor hippodrome = new HippodromeExecutor();
            results = hippodrome.startRace(horses, distance);
        }

        System.out.println("\nРезультати скачок:");

        Horse winner = results.get(0);
        Horse betHorseResult = horses.get(betHorse);

        if (winner.getName().equals(betHorseResult.getName())) {
            System.out.println("Вітаємо! Ваша ставка виграла!");
        } else {
            System.out.println("На жаль, ваша ставка програла.");
        }

        System.out.println("\nПідсумкова таблиця (місце, ім'я, час):");
        for (int i = 0; i < results.size(); i++) {
            Horse horse = results.get(i);
            System.out.println((i + 1) + ". " + horse.getName() +
                    " - " + horse.getRunTime() + " мс");
        }

        scanner.close();
    }
}