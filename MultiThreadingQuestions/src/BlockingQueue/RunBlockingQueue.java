package BlockingQueue;

public class RunBlockingQueue {
    public static void main(String[] args) {
        runBlockingQueue();
        //runBlockingQueueUsingSemaphore();
    }

    private static void runBlockingQueueUsingSemaphore() {
        BlockingQueueSemaphore<String> queue = new BlockingQueueSemaphore<String>(3);
        StringProducerThread producer = new StringProducerThread(queue);
        StringConsumerThread[] consumerThreads = new StringConsumerThread[3];
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i] = new StringConsumerThread(queue);
        }

        producer.start();
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i].start();
        }
    }

    private static void runBlockingQueue() {
        BlockingQueue<String> queue = new BlockingQueue<String>(3);
        StringProducerThread producer = new StringProducerThread(queue);
        StringConsumerThread[] consumerThreads = new StringConsumerThread[3];
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i] = new StringConsumerThread(queue);
        }

        producer.start();
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i].start();
        }
    }
}
