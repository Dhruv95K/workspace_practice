package sorting;

import java.util.Scanner;

public class QuickSort {

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static void quickSort(int arr[], int low, int high) {
		if (low < high) {

			int pi = new QuickSort().partition(arr, low, high);

			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			quickSort(arr, 0, n - 1);
			printArray(arr);
			T--;
		}
	}

	static int partition(int arr[], int low, int high) {
		// add your code here
		int i = low;
		int pivot = arr[high];

		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}

		swap(arr, i, high);

		return i;
	}

	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
