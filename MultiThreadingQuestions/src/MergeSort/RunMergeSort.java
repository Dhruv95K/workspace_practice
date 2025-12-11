package MergeSort;

import java.util.Random;

public class RunMergeSort {
    public static void main(String[] args) {
        // Create an array with 1000 random integers
        int[] arrayToSort = new int[10];
        Random random = new Random();
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = random.nextInt(10000); // Random numbers between 0 and 9999
        }

        System.out.println("Array size: " + arrayToSort.length);
        System.out.println("Testing single-threaded merge sort...");
        SingleThreadedMergeSort singleThreadedMergeSort = new SingleThreadedMergeSort(arrayToSort);
        int[] sortedArray = singleThreadedMergeSort.returnSortedArray();
        singleThreadedMergeSort.getTimeTaken();
//        System.out.print("Sorted array via single threaded mergesort is: ");
//        for (int num : sortedArray) {
//            System.out.print(num + " ");
//        }

        System.out.println("\nTesting multi-threaded merge sort...");
        MultiThreadedMergeSortWithExecutor multiThreadedMergeSortWithExecutor = new MultiThreadedMergeSortWithExecutor(arrayToSort);
        int[] sortedArrayMT = multiThreadedMergeSortWithExecutor.returnSortedArray();
        multiThreadedMergeSortWithExecutor.getTimeTaken();
//        System.out.print("Sorted array via multi threaded mergesort is: ");
//        for (int num : sortedArrayMT) {
//            System.out.print(num + " ");
//        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
