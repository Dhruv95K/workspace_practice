package BlockingQueue;

import java.util.Scanner;

public class StringProducerThread extends Thread {
    private final BlockingQueueInterface<String> queue;
    public StringProducerThread(BlockingQueueInterface<String> queue) {
        this.queue = queue;
    }
    @Override
    public void start() {
        System.out.println("Starting String Producer Thread");
        super.start();
    }
    private String produceString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    @Override
    public void run() {
        while(true){
            String str = produceString();
            if(str == null || str.equalsIgnoreCase("exit")){
                queue.terminate();
                System.out.println("String Producer Thread is terminating");
                return;
            }
            try {
                for(int i = 0 ; i < 5; i++){
                    queue.enqueue(str + " " + i);
                }
            } catch (InterruptedException e) {
                System.out.println("String Producer Thread interrupted: " + e.getMessage());
            }
        }
    }
    
}
