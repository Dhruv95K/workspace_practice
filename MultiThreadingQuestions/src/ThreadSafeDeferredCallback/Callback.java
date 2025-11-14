package ThreadSafeDeferredCallback;

import java.util.function.Consumer;

public class Callback<T> {
    private final long executeAt;
    private final T data;
    Consumer<T> action = (T d) -> {
        System.out.println("Executing callback with data: " + d);
    };
    Runnable onComplete = () -> {
        System.out.println("Callback execution completed.");
    };
    public Callback(long delay, T data) {
        this.executeAt = System.currentTimeMillis() + delay;
        this.data = data;
    }
    public void setOnComplete(Consumer<T> fn, T data) {
        this.onComplete = () -> fn.accept(data);
    }
    public long getExecuteAt() {
        return executeAt;
    }

    public T getData() {
        return data;
    }
}
