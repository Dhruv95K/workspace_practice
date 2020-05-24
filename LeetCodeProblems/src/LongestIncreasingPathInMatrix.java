import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*329. Longest Increasing Path in a Matrix
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally 
or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class LongestIncreasingPathInMatrix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int m = Integer.parseInt(read.readLine());
		int arr[][] = new int[n][m];
		String st[];
		for (int i = 0; i < n; i++) {
			st = read.readLine().trim().split(" ");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}
		int ans = longestIncreasingPath(arr);

		System.out.println(ans);
	}

	public static int longestIncreasingPath(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int ans = 0;

		int[][] dp = new int[n][m];

		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		for (int i = 0; i < n; i++) {
			int curr = 0;
			for (int j = 0; j < m; j++) {
				if (dp[i][j] == -1)
					curr = longestIncreasingPath(i, j, matrix, dp);
				ans = Math.max(ans, curr);
			}
		}

		return ans;
	}

	private static int longestIncreasingPath(int i, int j, int[][] matrix, int[][] dp) {
		int n = matrix.length;
		int m = matrix[0].length;
		if (i < 0 || i >= n || j < 0 || j >= m)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE, w = Integer.MIN_VALUE;

		if (j + 1 < m && matrix[i][j] < matrix[i][j + 1])
			x = 1 + longestIncreasingPath(i, j + 1, matrix, dp);

		if (j > 0 && matrix[i][j] < matrix[i][j - 1])
			y = 1 + longestIncreasingPath(i, j - 1, matrix, dp);

		if (i + 1 < n && matrix[i][j] < matrix[i + 1][j])
			z = 1 + longestIncreasingPath(i + 1, j, matrix, dp);

		if (i > 0 && matrix[i][j] < matrix[i - 1][j])
			w = 1 + longestIncreasingPath(i - 1, j, matrix, dp);

		dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(1, w))));

		return dp[i][j];
	}

	private static int longestIncreasingPath2(int i, int j, int[][] matrix, int[][] dp) {
		int n = matrix.length;
		int m = matrix[0].length;
		if (i < 0 || i >= n || j < 0 || j >= m)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int result = Integer.MIN_VALUE;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
			if(x>=0 && y>=0 && x<n && y<m && matrix[i][j] < matrix[x][y])
				result = Math.max(result, 1 + longestIncreasingPath2(x, y, matrix, dp));

		}

		dp[i][j] = Math.max(1, result);

		return dp[i][j];
	}
}
