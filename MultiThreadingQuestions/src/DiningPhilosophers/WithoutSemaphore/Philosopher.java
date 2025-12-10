package DiningPhilosophers.WithoutSemaphore;

public class Philosopher implements Runnable{
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private volatile boolean isFull = false;
    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void run() {
        while (!isFull) {
            contemplate();
            eat();
        }
    }
    public void eat() {
        if(leftFork.pickUp(this, State.LEFT_HAND)) {
            if (rightFork.pickUp(this, State.RIGHT_HAND)) {
                System.out.println("Philosopher-" + id + " is eating and will be full");
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    System.out.println("Eating was interrupted");
                    Thread.currentThread().interrupt();
                }
                this.isFull = true;
                rightFork.putDown(this, State.RIGHT_HAND);
            }
            else
                System.out.println("Philosopher-" + id + " couldn't pick up right fork and will put down left fork");
            leftFork.putDown(this, State.LEFT_HAND);
        }
    }
    private void contemplate() {
        System.out.println("Philosopher-" + id + " is contemplating.");
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            System.out.println("Contemplation was interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public int getId() {
        return id;
    }
}
