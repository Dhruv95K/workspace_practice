package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSumHalf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			System.out.println(subsetSum(arr, n));
		}

	}

	private static boolean subsetSum(int[] arr, int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i : arr)
			sum += i;

		if (sum % 2 != 0)
			return false;

		sum = sum / 2;

		/*
		 * boolean[][] subsetSum = new boolean[n+1][sum+1];
		 * 
		 * for(int i=0;i<=n;i++){ for(int j=0;j<=sum;j++) { if(j==0) { subsetSum[i][j] =
		 * true; continue; } if(i==0) { subsetSum[i][j] = false; continue; } if(arr[i-1]
		 * > j) subsetSum[i][j] = subsetSum[i-1][j]; else { subsetSum[i][j] =
		 * subsetSum[i-1][j] || subsetSum[i-1][j-arr[i-1]]; }
		 * 
		 * } }
		 * 
		 * 
		 * return subsetSum[n][sum];
		 */

		boolean[] subsetSum = new boolean[sum + 1];
		subsetSum[0] = true;

		for (int i = 0; i < n; i++) {
			for (int j = sum; j >= arr[i]; j--) {
				subsetSum[j] = subsetSum[j] || subsetSum[j - arr[i]];
			}
		}

		return subsetSum[sum]; // subsetSum[n][sum];
	}

}
