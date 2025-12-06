package DiningPhilosophers;

import java.util.concurrent.Semaphore;

public class DiningPhilosophersWithOrdering {
    private final Semaphore[] forks;
    private final int noOfPhilosophers;
    private final long startTime;

    public DiningPhilosophersWithOrdering(int numberOfPhilosophers) {
        this.noOfPhilosophers = numberOfPhilosophers;
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
        int leftFork = id % noOfPhilosophers;
        int rightFork = (id + 1) % noOfPhilosophers;

        if(leftFork == 0){
            forks[leftFork].acquire();
            forks[rightFork].acquire();
        }
        else {
            forks[rightFork].acquire();
            forks[leftFork].acquire();
        }
        System.out.println(Thread.currentThread().getName() + " is eating.");

        forks[leftFork].release();
        forks[rightFork].release();
    }
}
