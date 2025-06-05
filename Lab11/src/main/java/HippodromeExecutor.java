import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HippodromeExecutor {

    public List<Horse> startRace(List<Horse> horses, int distance) {
        ExecutorService executorService = Executors.newFixedThreadPool(horses.size());

        for (Horse horse : horses) {
            horse.setDistance(distance);
            executorService.submit(horse);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        horses.sort(Comparator.comparing(Horse::getRunTime));
        return horses;
    }
}