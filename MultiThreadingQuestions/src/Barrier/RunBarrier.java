package Barrier;

public class RunBarrier {
    public static void main(String[] args) {
        Barrier barrier = new Barrier(3);
        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread 1 is waiting at the barrier");
                    barrier.await();
                    System.out.println("Thread 1 is waiting at the barrier");
                    barrier.await();
                    System.out.println("Thread 1 is waiting at the barrier");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread p2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("Thread 2 is waiting at the barrier");
                    barrier.await();
                    Thread.sleep(500);
                    System.out.println("Thread 2 is waiting at the barrier");
                    barrier.await();
                    Thread.sleep(500);
                    System.out.println("Thread 2 is waiting at the barrier");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread p3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    System.out.println("Thread 3 is waiting at the barrier");
                    barrier.await();
                    Thread.sleep(1500);
                    System.out.println("Thread 3 is waiting at the barrier");
                    barrier.await();
                    Thread.sleep(1500);
                    System.out.println("Thread 3 is waiting at the barrier");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        p1.start();
        p2.start();
        p3.start();


    }
}
