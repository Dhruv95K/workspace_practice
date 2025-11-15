package ReadWriteLock;

public class ReadWriteLock {
    private int readers = 0;
    private boolean isWriting = false;

    public synchronized void acquireReadLock() {
        while (isWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        readers++;
    }

    public synchronized void releaseReadLock() {
        readers--;
        notifyAll();
    }

    public synchronized void acquireWriteLock() {
        while(isWriting || readers > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        isWriting = true;
    }

    public synchronized void releaseWriteLock() {
        isWriting = false;
        notifyAll();
    }
}
