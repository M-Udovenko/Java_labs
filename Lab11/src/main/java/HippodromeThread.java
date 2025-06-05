import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HippodromeThread {

    public List<Horse> startRace(List<Horse> horses, int distance) {
        List<Thread> threads = new ArrayList<>();

        for (Horse horse : horses) {
            horse.setDistance(distance);
            Thread thread = new Thread(horse);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        horses.sort(Comparator.comparing(Horse::getRunTime));
        return horses;
    }
}