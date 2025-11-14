package ThreadSafeDeferredCallback;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RunDeferredCallbackExecutor {
    public static void main(String[] args) {
        DeferredCallbackExecutor executor = new DeferredCallbackExecutor();

        Thread deferredCallbackExecutorService = new Thread(() -> {
            try {
                executor.start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        deferredCallbackExecutorService.setName("Deferred-Callback-Executor-Service-Thread");
        deferredCallbackExecutorService.start();

        Random random = new Random();
        Set<Thread> allThreads = new HashSet<>();

        for (int i = 0 ; i < 5; i++){
            Thread callbackRegisteringThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String callbackString = "callback from thread " + Thread.currentThread().getName();
                    Callback<String> callback = new Callback<>(random.nextInt(2000, 5000), callbackString);
                    callback.setOnComplete(RunDeferredCallbackExecutor::printString, callbackString);
                    executor.registerCallback(callback);
                }
            });
            callbackRegisteringThread.setName("Callback-Registering-Thread-" + i);
            allThreads.add(callbackRegisteringThread);
        }

        for (Thread t : allThreads){
            t.start();
        }

        for (Thread t : allThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void printString(String str){
        System.out.println(str);
    }
}
