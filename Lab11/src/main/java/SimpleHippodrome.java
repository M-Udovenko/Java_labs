import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleHippodrome {

    public static void main(String[] args) {
        int horseCount = 6;
        int distance = 1500;
        int betHorse = new Random().nextInt(horseCount);

        List<Horse> horses = createHorses(horseCount);

        System.out.println("ІПОДРОМ");
        System.out.println("Кількість коней: " + horseCount);
        System.out.println("Дистанція: " + distance + " м");
        System.out.println("Ставка на: " + horses.get(betHorse).getName());
        System.out.println();

        System.out.println("Учасники:");
        for (int i = 0; i < horses.size(); i++) {
            Horse horse = horses.get(i);
            System.out.println((i + 1) + ". " + horse.getName() +
                    " (швидкість: " + horse.getSpeed() + ")");
        }
        System.out.println();

        System.out.println("ПОЧИНАЄМО ГОНКУ!");

        HippodromeExecutor hippodrome = new HippodromeExecutor();
        List<Horse> results = hippodrome.startRace(horses, distance);

        System.out.println();
        System.out.println("РЕЗУЛЬТАТИ:");

        Horse winner = results.get(0);
        Horse betHorseResult = horses.get(betHorse);

        if (winner.getName().equals(betHorseResult.getName())) {
            System.out.println("*** СТАВКА ВИГРАЛА! ***");
        } else {
            System.out.println("Ставка програла.");
        }

        System.out.println();
        System.out.println("Фінальна таблиця:");
        for (int i = 0; i < results.size(); i++) {
            Horse horse = results.get(i);
            String position = String.format("%d місце", i + 1);
            String time = String.format("%.2f сек", horse.getRunTime() / 1000.0);
            System.out.println(position + ": " + horse.getName() + " - " + time);
        }
    }

    private static List<Horse> createHorses(int count) {
        String[] names = {
                "Чорна Блискавка", "Білий Вітер", "Золота Стріла",
                "Червоний Грім", "Синій Дощ", "Срібна Куля",
                "Швидкий Вогонь", "Дикий Захід", "Вільний Дух", "Хоробрий Воїн"
        };

        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = names[i % names.length];
            if (i >= names.length) {
                name += "-" + (i / names.length + 1);
            }
            horses.add(new Horse(name));
        }
        return horses;
    }
}