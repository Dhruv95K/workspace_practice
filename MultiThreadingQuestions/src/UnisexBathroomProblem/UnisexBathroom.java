package UnisexBathroomProblem;

public class UnisexBathroom {
    private int empCount;
    private int maleCount;
    private int femaleCount;
    //private ReentrantLock bathroomLock = new ReentrantLock(true);

    private void useBathroom(String name, int empCountSnapshot) {
        System.out.println(name + " is using bathroom. Current employees in bathroom: " + empCountSnapshot);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted while using bathroom.");
        }
        System.out.println(name + " is leaving bathroom.");
    }
    public void maleUseBathroom(String name) throws InterruptedException{
        int empCountSnapshot;
        synchronized (this){
            while(empCount >= 3 || femaleCount > 0){
                System.out.println(name + " is waiting to use bathroom.");
                wait();
            }
            maleCount++;
            empCount++;
            empCountSnapshot = empCount;
        }
        useBathroom(name, empCountSnapshot);
        synchronized (this){
            empCount--;
            maleCount--;
            notifyAll();
        }
    }
    public void femaleUseBathroom(String name) throws InterruptedException{
        int empCountSnapshot;
        synchronized (this){
            while(empCount >= 3 || maleCount > 0){
                System.out.println(name + " is waiting to use bathroom.");
                wait();
            }
            femaleCount++;
            empCount++;
            empCountSnapshot = empCount;
        }
        useBathroom(name, empCountSnapshot);
        synchronized (this){
            empCount--;
            femaleCount--;
            notifyAll();
        }
    }
}
