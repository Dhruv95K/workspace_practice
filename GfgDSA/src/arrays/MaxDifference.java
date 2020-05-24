package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxDifference {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim()); // size of array
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
			}

			MaxDifference obj = new MaxDifference();

			System.out.println(obj.maxIndexDiff(arr, n)); // print the result
		}
	}

	static int maxIndexDiff(int arr[], int n) {
		// Your code here
		int[] Lmin = new int[n];
		int[] Rmax = new int[n];
		Lmin[0] = arr[0];
		Rmax[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			Lmin[i] = Math.min(arr[i], Lmin[i - 1]);
			Rmax[n - 1 - i] = Math.max(arr[n - 1 - i], Rmax[n - i]);
		}

		System.out.println(Arrays.toString(Lmin));
		System.out.println(Arrays.toString(Rmax));

		int i = 0, j = 0, maxDif = -1;

		while (i < n && j < n) {
			if (Lmin[i] <= Rmax[j]) {
				maxDif = Math.max(maxDif, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}
		
		return maxDif;
	}

}
