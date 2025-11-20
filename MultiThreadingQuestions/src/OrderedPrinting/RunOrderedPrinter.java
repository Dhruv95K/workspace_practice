package OrderedPrinting;

public class RunOrderedPrinter {
    public static void main(String[] args) throws InterruptedException {
        OrderedPrinter orderedPrinter = new OrderedPrinter();

        Thread threadA = new Thread(() -> {
            orderedPrinter.printFirst();
        });

        Thread threadB = new Thread(() -> {
            try {
                orderedPrinter.printSecond();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                orderedPrinter.printThird();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadC.start();
        Thread.sleep(3000);
        threadB.start();
        Thread.sleep(3000);
        threadA.start();

        threadC.join();
        threadB.join();
        threadA.join();
    }
}
