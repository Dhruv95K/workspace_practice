package DiningPhilosophers.WithoutSemaphore;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final int id;
    private final ReentrantLock lock;

    public Fork(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher philosopher, State state) {
        try {
            if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                System.out.println(philosopher.getId() + " picked up Fork-" + id + "in" + state);
                return true;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean putDown(Philosopher philosopher, State state) {
        lock.unlock();
        System.out.println(philosopher.getId() + " put down Fork-" + id + "from" + state);
        return true;
    }
}

enum State {
    RIGHT_HAND,
    LEFT_HAND;
}
