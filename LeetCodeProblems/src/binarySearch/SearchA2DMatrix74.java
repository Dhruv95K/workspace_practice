package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
	Input:
	matrix = [
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	target = 3
	Output: true
	
Example 2:
	Input:
	matrix = [
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	target = 13
	Output: false
*/

public class SearchA2DMatrix74 {

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
		
		int target = Integer.parseInt(br.readLine());
		
		System.out.println(searchMatrix(arr,target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		if(n==0)
			return false;
		
		int m = matrix[0].length;
		
		int i = 0, j = m - 1;
		while (i < n && j >= 0) {
			if (matrix[i][j] > target)
				j--;
			else if (matrix[i][j] < target)
				i++;
			else
				return true;
		}

		return false;
	}

	public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
		int n = matrix.length;
		if(n==0)
			return false;
		
		int m = matrix[0].length;
		
		for(int i = 0;i<n;i++) {
			if(m >0 && matrix[i][m-1] >= target)
				 return search(matrix[i], target) == -1 ? false : true;
		}
		
		return false;
	}
	
	public static int search(int[] nums, int target) {

		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;

		}

		return -1;
	}

}
