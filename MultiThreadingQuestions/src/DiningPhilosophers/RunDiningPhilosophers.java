package DiningPhilosophers;

import java.util.Set;

public class RunDiningPhilosophers {
    public static void main(String[] args) {
        //DiningPhilosophersWithLimit diningPhilosophers = new DiningPhilosophersWithLimit(5);

        DiningPhilosophersWithOrdering diningPhilosophers = new DiningPhilosophersWithOrdering(5);

        Set<Thread> allPhilosophers = new java.util.HashSet<>();

        for (int i = 0; i < 5; i++) {
            int philosopherId = i + 1;
            Thread thread = new Thread(() -> {
                try {
                    diningPhilosophers.startLifecycleOfPhilosopher(philosopherId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Philosopher-" + philosopherId);
            allPhilosophers.add(thread);
        }

        for(Thread philosopher : allPhilosophers) {
            philosopher.start();
        }

        for (Thread philosopher : allPhilosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
