package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortedRotated {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine()); // input size of array
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
			}

			SortedRotated obj = new SortedRotated();

			if (!(obj.checkRotatedAndSorted(arr, n)))
				System.out.println("No"); // print the result
			else
				System.out.println("Yes");
		}
	}

	public static boolean checkRotatedAndSorted(int arr[], int n) {

		// Your code here
		int[] min_max = findMinMax(arr);

		if (min_max[0] - min_max[1] == 1) {
			return checkForAscending(arr, n, min_max);
		} else if (min_max[0] - min_max[1] == -1) {
			return checkForDescending(arr, n, min_max);
		} else
			return false;
	}

	private static boolean checkForDescending(int[] arr, int n, int[] min_max) {
		// TODO Auto-generated method stub
		for (int i = 0; i < min_max[0]; i++) {
			if (arr[i] < arr[i + 1])
				return false;
		}

		for (int i = min_max[1]; i < n - 1; i++) {
			if (arr[i + 1] > arr[i])
				return false;
		}

		if (arr[n - 1] < arr[0])
			return false;

		return true;
	}

	private static boolean checkForAscending(int[] arr, int n, int[] min_max) {
		for (int i = 0; i < min_max[1]; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}

		for (int i = min_max[0]; i < n - 1; i++) {
			if (arr[i + 1] < arr[i])
				return false;
		}

		if (arr[n - 1] > arr[0])
			return false;

		return true;
	}

	private static int[] findMinMax(int[] arr) {
		// TODO Auto-generated method stub

		int max = 0, min = Integer.MAX_VALUE;
		int i = 0, j = 0;

		for (int k = 0; k < arr.length; k++) {
			if (arr[k] > max) {
				j = k;
				max = arr[k];
			}

			if (arr[k] < min) {
				i = k;
				min = arr[k];
			}
		}

		return new int[] { i, j };
	}

}
