package DiningPhilosophers.WithoutSemaphore;

public class DiningPhilosophersConstants {
    public final int NUMBER_OF_PHILOSOPHERS;
    public final int NUMBER_OF_FORKS;
    public DiningPhilosophersConstants(int numberOfPhilosophers, int numberOfForks) {
        this.NUMBER_OF_PHILOSOPHERS = numberOfPhilosophers;
        this.NUMBER_OF_FORKS = numberOfForks;
    }
}
