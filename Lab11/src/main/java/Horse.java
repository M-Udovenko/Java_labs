import java.util.Random;

public class Horse implements Runnable {
    private String name;
    private int speed;
    private int distance;
    private long startTime;
    private long finishTime;
    private boolean finished;

    public Horse(String name) {
        this.name = name;
        this.speed = new Random().nextInt(50) + 10;
        this.finished = false;
    }

    public void run(int length) {
        this.distance = length;
        this.startTime = System.currentTimeMillis();

        int currentPosition = 0;
        while (currentPosition < distance) {
            try {
                Thread.sleep(100 - speed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            currentPosition += speed;
        }

        this.finishTime = System.currentTimeMillis();
        this.finished = true;
    }

    @Override
    public void run() {
        run(distance);
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public long getRunTime() {
        return finishTime - startTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}