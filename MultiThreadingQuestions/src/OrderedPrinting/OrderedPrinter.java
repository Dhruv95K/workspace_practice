package OrderedPrinting;

public class OrderedPrinter {
    private volatile int count;
    public OrderedPrinter() {
        this.count = 1;
    }
    public void printFirst() {
        synchronized (this){
            System.out.println("First");
            this.count++;
            notifyAll();
        }
    }
    public void printSecond() throws InterruptedException {
        synchronized (this) {
            while(count != 2) {
                System.out.println("Second waiting");
                wait();
            }
            System.out.println("Second");
            this.count++;
            notifyAll();
        }
    }
    public void printThird() throws InterruptedException {
        synchronized (this) {
            while(count != 3) {
                System.out.println("Third waiting");
                wait();
            }
            System.out.println("Third");
            this.count++;
            notifyAll();
        }
    }
}
