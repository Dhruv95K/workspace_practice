package ThreadSafeDeferredCallback;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeferredCallbackExecutor {
    PriorityQueue<Callback<?>> callbackQueue = new PriorityQueue<>(new Comparator<Callback<?>>() {
        @Override
        public int compare(Callback<?> o1, Callback<?> o2) {
            return (int) (o1.getExecuteAt() - o2.getExecuteAt());
        }
    });

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition newCallbackArrived = lock.newCondition();

    private long calculateSleepTime() {
        long currentTime = System.currentTimeMillis();
        return callbackQueue.peek().getExecuteAt() - currentTime;
    }

    public void start() throws InterruptedException {
        long timeToSleep = 0;

        while(true){
            lock.lock();
            try{
                while(callbackQueue.isEmpty())
                    newCallbackArrived.await();

                while(!callbackQueue.isEmpty()){
                    timeToSleep = calculateSleepTime();

                    if(timeToSleep <= 0)
                        break;

                    newCallbackArrived.await(timeToSleep, TimeUnit.MILLISECONDS);
                }

                Callback<?> callback = callbackQueue.poll();
                System.out.println("Executing callback scheduled for " + callback.getExecuteAt() +
                        " at time " + System.currentTimeMillis() + " in thread " +
                        Thread.currentThread().getName());
                System.out.println("Callback data: " + callback.getData().toString());
                callback.onComplete.run();
                System.out.println(" --------------------------------------- ");
            } finally {
                lock.unlock();
            }
        }
    }
    public void registerCallback(Callback<?> callback) {
        lock.lock();
        try {
            callbackQueue.add(callback);
            newCallbackArrived.signal();
        } finally {
            lock.unlock();
        }
    }
}
