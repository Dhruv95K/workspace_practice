package MergeSort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedMergeSortWithExecutor {
    private final int[] array;
    private final int[] tempArray;
    private long timeForMergeSort;
    private final ExecutorService executorService;
    public MultiThreadedMergeSortWithExecutor(int[] arrayToSort) {
        this.array = arrayToSort;
        this.tempArray = new int[arrayToSort.length];
        timeForMergeSort = 0;
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(numberOfProcessors);
    }
    public int[] returnSortedArray() {
        long startTime = System.currentTimeMillis();

        CountDownLatch mergeDone = new CountDownLatch(1);
        mergeSort(this.array, 0, this.array.length - 1, mergeDone);
        try {
            mergeDone.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }  finally {
            executorService.shutdown();
        }

        long endTime = System.currentTimeMillis();
        timeForMergeSort = endTime - startTime;
        return this.array;
    }
    private void mergeSort(int[] array, int start, int end, CountDownLatch doneSignal) {
        if(start >= end) {
            doneSignal.countDown();
            return;
        }

        int mid = start + (end - start) / 2;
        CountDownLatch leftDone = new CountDownLatch(1);
        CountDownLatch rightDone = new CountDownLatch(1);

        executorService.execute(() ->
                mergeSort(array, start, mid, leftDone));
        executorService.execute(() ->
                mergeSort(array, mid + 1, end, rightDone));

        try {
            leftDone.await();
            rightDone.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if(array[i] <= array[j]) {
                tempArray[k] = array[i];
                i++;
            }
            else if(array[j] < array[i]){
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            tempArray[k] = array[i];
            k++;i++;
        }
        while (j <= end) {
            tempArray[k] = array[j];
            k++;j++;
        }

        for(int index = start; index <= end; index++) {
            array[index] = tempArray[index];
        }

        doneSignal.countDown();
//        System.out.print("current state is: ");
//        printArray();
    }

    public void printArray() {
        int n = array.length;
        for (int j : array)
            System.out.print(j + " ");

        System.out.println();
    }
    public void getTimeTaken(){
        System.out.println("Time taken for multi threaded mergesort is: " + timeForMergeSort + " ms");
    }
}
