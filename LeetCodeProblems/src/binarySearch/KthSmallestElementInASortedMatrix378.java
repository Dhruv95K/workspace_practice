package binarySearch;
/*
378. Kth Smallest Element in a Sorted Matrix
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in 
the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
	matrix = [
	   [ 1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	k = 8,
	return 13.
			
Note:
	1. You may assume k is always valid, 1 ¡Ü k ¡Ü n2.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthSmallestElementInASortedMatrix378 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];
		String[] input;

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(",");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(input[i]);
		}

		int k = Integer.parseInt(br.readLine());

		System.out.println(kthSmallest(arr, k));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int ans = -1;
		int l = matrix[0][0], r = matrix[n - 1][n - 1];

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int count = 0;
			for (int[] mat : matrix) {
				int index = findSmallerOrEqual(mat, mid);
				count += index + 1;
			}
			if (count >= k) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}
		
		return ans;
	}

	private static int findSmallerOrEqual(int[] mat, int target) {
		int l = 0, r = mat.length - 1;
		int ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mat[mid] <= target) {
				ans = mid;
				l = mid + 1;
			} else
				r = mid - 1;

		}
		return ans;
	}
}
