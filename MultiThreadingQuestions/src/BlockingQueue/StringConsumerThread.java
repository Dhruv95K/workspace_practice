package BlockingQueue;

import java.util.Scanner;

public class StringConsumerThread extends Thread {
    private final BlockingQueueInterface<String> queue;
    public StringConsumerThread(BlockingQueueInterface<String> queue) {
        this.queue = queue;
    }
    @Override
    public void start() {
        System.out.println("Starting String Consumer Thread");
        super.start();
    }
    private String consumeString() {
        try {
            return queue.dequeue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while(true){
            String str = consumeString();
            if(str == null){
                System.out.println("String Consumer Thread is terminating");
                return;
            }
            System.out.println("Consumed String: " + str + " by " + Thread.currentThread().getName());
        }
    }
    
}
