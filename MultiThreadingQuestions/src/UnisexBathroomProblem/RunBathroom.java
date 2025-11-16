package UnisexBathroomProblem;

public class RunBathroom {
    public static void main(String[] args) throws InterruptedException {
        UnisexBathroom bathroom = new UnisexBathroom();
        Thread female1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bathroom.femaleUseBathroom("lisa");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread male1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bathroom.maleUseBathroom("john");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread male2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bathroom.maleUseBathroom("mike");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread male3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bathroom.maleUseBathroom("tom");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread male4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bathroom.maleUseBathroom("james");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        female1.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();

        female1.join();
        male1.join();
        male2.join();
        male3.join();
        male4.join();

    }
}
