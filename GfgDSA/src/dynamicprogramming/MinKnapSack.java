package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinKnapSack {  //// with duplicate items

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(input[i]);
		}
			
		n = Integer.parseInt(br.readLine());
		int[] arr2 = new int[n];
		input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(input[i]);
		}

		n = Integer.parseInt(br.readLine());
		int[] arr3 = new int[n];
		input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr3[i] = Integer.parseInt(input[i]);
		}

		System.out.println(solve(arr1, arr2, arr3));
	}

	public static int solve(final int[] A, final int[] B, final int[] C) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result += minKnapSack(A[i], B, C);
		}

		return result;
	}

	public static int minKnapSack(int w, int[] wt, int[] val) {
		int n = wt.length;
		int[] knapSack = new int[w + 1];

		knapSack[0] = 0;

		for (int i = 1; i <= w; i++) {
			knapSack[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (wt[j] <= i)
					knapSack[i] = Math.min(knapSack[i], knapSack[i - wt[j]] + val[j]);
			}
		}

		return knapSack[w];
	}

	/*
	 * 5 2 3 1 5 4 4 3 2 4 1 4 1 2 5 10
	 */

}
