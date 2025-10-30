package BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueUsingLock<T> implements BlockingQueueInterface<T>{
    private final Queue<T> queue;
    private final static int CAPACITY = 5;
    private boolean isEmpty = true;
    private boolean isTerminate = false;
    private final Lock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();
    private final Condition consumerCondition = lock.newCondition();

    public BlockingQueueUsingLock() {
        queue = new LinkedList<>();
    }
    public void enqueue(T item) throws InterruptedException {
        if(isTerminate){
            return;
        }

        lock.lock();
        try{
            while(queue.size() == CAPACITY){
                producerCondition.await();
            }

            queue.add(item);
            isEmpty = false;
            consumerCondition.signalAll();
        }
        finally {
            lock.unlock();
        }

    }

    public synchronized T dequeue() throws InterruptedException {
        lock.lock();
        T item = null;
        try {
            while (isEmpty && !isTerminate) {
                consumerCondition.await();
            }
            if (queue.size() == 1) {
                isEmpty = true;
            }

            if(queue.isEmpty() && isTerminate){
                return null;
            }

            item = queue.remove();
            if (queue.size() == CAPACITY - 1) {
                producerCondition.signalAll();
            }
            return item;
        }
        finally {
            lock.unlock();
        }
    }
    public void terminate() {
        lock.lock();
        try {
            isTerminate = true;
            consumerCondition.signalAll();
            producerCondition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
}
