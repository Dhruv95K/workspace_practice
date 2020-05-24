package sorting;

import java.util.Scanner;

public class InsertionSort {

	static void insertionSort(int arr[], int n) {
		int i;
		for (i = 1; i < n; i++)
			new InsertionSort().insert(arr, i);
	}

	static void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			insertionSort(a, n);
			printArray(a, n);

			t--;
		}

	}

	static void insert(int arr[], int i) {
		// Your code here
		
			int key = arr[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > key)
					arr[j + 1] = arr[j];
				else {
					break;
				}
			}

			arr[j + 1] = key;
		

	}

}
