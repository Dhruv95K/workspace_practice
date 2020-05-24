package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1351. Count Negative Numbers in a Sorted Matrix
Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 

Return the number of negative numbers in grid.

Example 1:
	Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
	Output: 8
	Explanation: There are 8 negatives number in the matrix.

Example 2:
	Input: grid = [[3,2],[1,0]]
	Output: 0

Example 3:
	Input: grid = [[1,-1],[-1,-1]]
	Output: 3

Example 4:
	Input: grid = [[-1]]
	Output: 1
 
Constraints:
	1. m == grid.length
	2. n == grid[i].length
	3. 1 <= m, n <= 100
	4. -100 <= grid[i][j] <= 100
*/

public class CountNegativeNumbersInASortedMatrix1351 {

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

		System.out.println(countNegatives(arr));
	}

	public static int countNegatives(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		
		int count = 0;
		for(int[] arr : grid) {
			int index = findFirstNegative(arr);
			if(index != -1)
				count += (arr.length - index);
		}
		
		return count;
	}

	private static int findFirstNegative(int[] arr) {
		int l = 0, r = arr.length - 1;
		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] >= 0)
				l = mid + 1;
			else {
				ans = mid;
				r = mid - 1;
			}
		}
		
		return ans;
	}
}
