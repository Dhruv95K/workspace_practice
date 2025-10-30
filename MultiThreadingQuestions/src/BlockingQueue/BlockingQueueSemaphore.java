package BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BlockingQueueSemaphore<T> implements BlockingQueueInterface<T>{
    private final Queue<T> queue;
    private final int CAPACITY;
    public BlockingQueueSemaphore(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be > 0");

        this.CAPACITY = capacity;
        this.queue = new LinkedList<>();
        producerSemaphore = new Semaphore(CAPACITY);
        consumerSemaphore = new Semaphore(0);
    }

    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;

    private final Semaphore queueLock = new Semaphore(1, true);

    public void enqueue(T item) throws InterruptedException {
        if (item == null)
            throw new NullPointerException();

        producerSemaphore.acquire();
        boolean enqueued = false;
        try {
            queueLock.acquire();
            try {
                queue.add(item);
                enqueued = true;
            } finally {
                queueLock.release();
            }
        } catch (Exception e) {
            System.out.println("Exception while enqueuing: " + e.getMessage());
        } finally {
            if(!enqueued)
                producerSemaphore.release();
        }


        consumerSemaphore.release();
    }

    public T dequeue() throws InterruptedException {
        consumerSemaphore.acquire();
        T item = null;
        queueLock.acquire();
        try {
            item = queue.remove();
        } finally {
            queueLock.release();
        }

        producerSemaphore.release();
        return item;
    }
    public void terminate() {
        // No specific termination logic needed for semaphore-based implementation
    }
}
