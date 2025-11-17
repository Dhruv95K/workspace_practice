package Barrier;

public class Barrier {
    private int numberOfThreads;
    private int count;
    private int releasedThreads;
    public Barrier(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.count = 0;
        this.releasedThreads = 0;
    }

    public synchronized void await() throws InterruptedException {

        while(count == numberOfThreads){
            wait();
        }

        count++;
        if(count == numberOfThreads){
            releasedThreads = count;
            notifyAll();
        } else {
            while(count < numberOfThreads){
                wait();
            }
        }

        releasedThreads--;
        if(releasedThreads == 0){
            count = 0;
            notifyAll();
        }
    }
}
