package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinSumPartition {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			System.out.println(minSumPart(arr, n));
		}
	}

	static int min = 0;

	private static int minSumPart(int[] arr, int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i : arr)
			sum += i;

		min = 0;
		return minSumPart(arr, n - 1, 0, sum);
	}

	private static int minSumPart(int[] arr, int i, int currSum, int totalSum) {

		if (i < 0) {
			return Math.abs(totalSum - currSum - currSum);
		}

		return Math.min(minSumPart(arr, i - 1, currSum + arr[i], totalSum), 
								minSumPart(arr, i - 1, currSum, totalSum));
	}

}