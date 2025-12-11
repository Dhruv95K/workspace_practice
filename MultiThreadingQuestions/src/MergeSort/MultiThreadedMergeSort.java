package MergeSort;

public class MultiThreadedMergeSort {
    private final int[] array;
    private final int[] tempArray;
    private long timeForMergeSort;
    public MultiThreadedMergeSort(int[] arrayToSort) {
        this.array = arrayToSort;
        this.tempArray = new int[arrayToSort.length];
        timeForMergeSort = 0;
    }
    public int[] returnSortedArray() {
        long startTime = System.currentTimeMillis();
        mergeSort(this.array, 0, this.array.length - 1);
        long endTime = System.currentTimeMillis();
        timeForMergeSort = endTime - startTime;
        return this.array;
    }
    private void mergeSort(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        Thread leftSorter = new Thread(() -> mergeSort(array, start, mid));
        Thread rightSorter = new Thread(() -> mergeSort(array, mid + 1, end));

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
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
