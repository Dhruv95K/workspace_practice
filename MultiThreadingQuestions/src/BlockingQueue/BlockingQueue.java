package BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> implements BlockingQueueInterface<T> {
    private Queue<T> queue;
    private final int CAPACITY;
    private boolean isEmpty = true;
    private boolean isTerminate = false;

    public BlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.CAPACITY = capacity;
    }
    public synchronized void enqueue(T item) throws InterruptedException {
        if(isTerminate){
            return;
        }

        while(queue.size() == CAPACITY){
            System.out.println("Queue is full, producer is waiting - " + Thread.currentThread().getName());
            wait();
        }

        queue.add(item);
        isEmpty = false;
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (isEmpty && !isTerminate) {
            System.out.println("Queue is empty, consumer is waiting - " + Thread.currentThread().getName());
            wait();
        }

        if (queue.size() == 1) {
            isEmpty = true;
        }

        if(queue.isEmpty() && isTerminate){
            return null;
        }

        T item = queue.remove();
        if (queue.size() == CAPACITY - 1) {
            notifyAll();
        }
        return item;
    }

    public synchronized void terminate() {
        isTerminate = true;
        notifyAll();
    }

    public static void main(String[] args) {
        System.out.println("Blocking Queue Example");

    }
}
