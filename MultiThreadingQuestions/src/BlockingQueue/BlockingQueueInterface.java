package BlockingQueue;

public interface BlockingQueueInterface<T> {
    void enqueue(T item) throws InterruptedException;
    T dequeue() throws InterruptedException;
    void terminate();
}
