package sorting;

import java.util.Scanner;

public class BubbleSort {

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			bubbleSort(arr, n);
			printArray(arr);

			t--;
		}
	}

	static void bubbleSort(int arr[], int n) {
		int i, j;
		for (i = 0; i < n - 1; i++)
			new BubbleSort().bubble(arr, i, n);
	}

	static void bubble(int arr[], int i, int n) {
		// add your code here
		for (int k = 0; k < n - i - 1; k++) {
			if (arr[k] > arr[k + 1])
				swap(arr, k, k + 1);
		}

	}

	public static void swap(int[] arr, int a, int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
}
