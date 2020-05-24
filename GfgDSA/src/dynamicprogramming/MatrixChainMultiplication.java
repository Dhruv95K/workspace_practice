package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixChainMultiplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] input = br.readLine().split(", ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		System.out.println(solve(arr));
	}

	// 15, 50, 3, 50, 50, 47

	public static int solve(int[] A) {
		int prod = 1;
		if (A.length == 3) {
			for (int i : A)
				prod = prod * i;
			return prod;
		}

		int n = A.length;
		int[][] multiply = new int[n][n];

		for (int l = 1; l <= n; l++) {
			for (int i = 1; i <= n - l; i++) {
				int j = i + l - 1;
				multiply[i][j] = Integer.MAX_VALUE;
				if (l == 1) {
					multiply[i][j] = 0;
					continue;
				}

				for (int k = i; k < j; k++) {
					multiply[i][j] = Math.min(multiply[i][j],multiply[i][k] + multiply[k+1][j] + 
															A[i-1]*A[k]*A[j]);
				}
			}
		}

		return multiply[1][n-1];
	}

}
