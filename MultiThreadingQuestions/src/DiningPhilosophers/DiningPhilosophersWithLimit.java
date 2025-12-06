package DiningPhilosophers;

import java.util.concurrent.Semaphore;

public class DiningPhilosophersWithLimit {
    private final Semaphore[] forks;
    private final Semaphore maxDiners;
    private final int noOfPhilosophers;
    private final long startTime;

    public DiningPhilosophersWithLimit(int numberOfPhilosophers) {
        this.noOfPhilosophers = numberOfPhilosophers;
        maxDiners = new Semaphore(noOfPhilosophers - 1);
        forks = new Semaphore[noOfPhilosophers];

        for (int i = 0; i < noOfPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }

        this.startTime = System.currentTimeMillis();
    }

    public void startLifecycleOfPhilosopher(int id) throws InterruptedException {
        while(true){
            contemplate();
            eat(id);
            if(System.currentTimeMillis() - startTime > 10000){
                System.out.println("Terminating the dining philosophers simulation.");
                break;
            }
        }
    }

    private void contemplate() {
        System.out.println(Thread.currentThread().getName() + " is contemplating.");
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            System.out.println("Contemplation was interrupted");
            Thread.currentThread().interrupt();
        }
    }

    private void eat(int id) throws InterruptedException {
        maxDiners.acquire();

        int leftFork = id % noOfPhilosophers;
        int rightFork = (id + 1) % noOfPhilosophers;

        forks[leftFork].acquire();
        forks[rightFork].acquire();

        System.out.println(Thread.currentThread().getName() + " is eating.");

        forks[leftFork].release();
        forks[rightFork].release();

        maxDiners.release();
    }
}
