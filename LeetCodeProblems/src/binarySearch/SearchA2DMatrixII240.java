package binarySearch;
/*
240. Search a 2D Matrix II
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchA2DMatrixII240 {

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
		
		System.out.println(searchMatrix(arr,k));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		if (n == 0)
			return false;
		int m = matrix[0].length;

		int r = 0, c = m - 1;

		while (r < n && c >= 0) {
			if (target == matrix[r][c])
				return true;
			if (target > matrix[r][c])
				r++;
			else
				c--;

		}

		return false;

	}

}
