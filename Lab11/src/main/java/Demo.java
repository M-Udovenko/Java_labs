import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Демонстрація роботи іподрому");

        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Швидкий"));
        horses.add(new Horse("Блискавка"));
        horses.add(new Horse("Вітер"));
        horses.add(new Horse("Стріла"));
        horses.add(new Horse("Грім"));

        int distance = 1000;

        System.out.println("\nТест з Thread:");
        testWithThread(horses, distance);

        System.out.println("\nТест з ExecutorService:");
        testWithExecutor(horses, distance);
    }

    private static void testWithThread(List<Horse> horses, int distance) {
        List<Horse> horsesCopy = copyHorses(horses);

        HippodromeThread hippodrome = new HippodromeThread();
        long startTime = System.currentTimeMillis();
        List<Horse> results = hippodrome.startRace(horsesCopy, distance);
        long totalTime = System.currentTimeMillis() - startTime;

        printResults(results, totalTime);
    }

    private static void testWithExecutor(List<Horse> horses, int distance) {
        List<Horse> horsesCopy = copyHorses(horses);

        HippodromeExecutor hippodrome = new HippodromeExecutor();
        long startTime = System.currentTimeMillis();
        List<Horse> results = hippodrome.startRace(horsesCopy, distance);
        long totalTime = System.currentTimeMillis() - startTime;

        printResults(results, totalTime);
    }

    private static List<Horse> copyHorses(List<Horse> original) {
        List<Horse> copy = new ArrayList<>();
        for (Horse horse : original) {
            Horse newHorse = new Horse(horse.getName());
            copy.add(newHorse);
        }
        return copy;
    }

    private static void printResults(List<Horse> results, long totalTime) {
        System.out.println("Результати гонки:");
        for (int i = 0; i < results.size(); i++) {
            Horse horse = results.get(i);
            System.out.println((i + 1) + ". " + horse.getName() +
                    " (швидкість: " + horse.getSpeed() +
                    ", час: " + horse.getRunTime() + " мс)");
        }
        System.out.println("Загальний час виконання: " + totalTime + " мс");
    }
}