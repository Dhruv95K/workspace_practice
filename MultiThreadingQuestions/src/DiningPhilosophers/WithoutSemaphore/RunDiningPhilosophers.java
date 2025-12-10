package DiningPhilosophers.WithoutSemaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunDiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        int numberOfPhilosophers = 5;
        int numberOfForks = 5;

        DiningPhilosophersConstants constants = new DiningPhilosophersConstants(numberOfPhilosophers, numberOfForks);
        Fork[] forks = null;
        ExecutorService executorService = null;
        Philosopher[] philosophers = null;

        try{
            forks = new Fork[constants.NUMBER_OF_FORKS];
            for (int i = 0; i < numberOfForks; i++) {
                forks[i] = new Fork(i+1);
            }

            philosophers = new Philosopher[constants.NUMBER_OF_PHILOSOPHERS];
            executorService = Executors.newFixedThreadPool(numberOfPhilosophers);

            for (int i = 0; i < numberOfPhilosophers; i++) {
                Fork leftFork = forks[i];
                Fork rightFork = forks[(i + 1) % numberOfForks];
                philosophers[i] = new Philosopher(i + 1, leftFork, rightFork);
                executorService.execute(philosophers[i]);
            }

        } finally {
            if(executorService != null){
                executorService.shutdown();
                while(!executorService.isTerminated())
                    Thread.sleep(1000);
            }
        }

    }
}
