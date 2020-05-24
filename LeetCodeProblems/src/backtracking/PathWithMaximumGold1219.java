package backtracking;
/*
1219. Path with Maximum Gold
In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that 
cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:
	Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
	Output: 24
	Explanation:
	[[0,6,0],
	 [5,8,7],
	 [0,9,0]]
	Path to get the maximum gold, 9 -> 8 -> 7.

Example 2:	
	Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
	Output: 28
	Explanation:
	[[1,0,7],
	 [2,0,6],
	 [3,4,5],
	 [0,3,0],
	 [9,0,20]]
	Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:
	1. 1 <= grid.length, grid[i].length <= 15
	2. 0 <= grid[i][j] <= 100
	3. There are at most 25 cells containing gold.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathWithMaximumGold1219 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];
		String st[];
		for (int i = 0; i < n; i++) {
			st = br.readLine().trim().split(" ");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}

		int ans = getMaximumGold(arr);
		System.out.println(ans);
	}

	static boolean[][] visited;
	static int[][] dp;
	public static int getMaximumGold(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		visited = new boolean[n][m];
		dp = new int[n][m];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (/*dp[i][j] == 0 && */visited[i][j] == false && grid[i][j] != 0)
					ans = Math.max(ans, getMaximumGoldBackTrack(grid, i, j));
			}
		}
		return ans;
	}

	private static int getMaximumGoldBackTrack(int[][] grid, int i, int j) {
		int n = grid.length;
		int m = grid[0].length;
		if (i >= n || i < 0 || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j] == true)
			return 0;

		int sum = Integer.MIN_VALUE;
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < n && y >= 0 && y < m)
				sum = Math.max(sum, grid[i][j] + getMaximumGoldBackTrack(grid, x, y));
		}

		visited[i][j] = false;
		return sum;
	}
	
	// this is wrong
	private static int getMaximumGold(int[][] grid, int i, int j) {
		int n = grid.length;
		int m = grid[0].length;
		if (i >= n || i < 0 || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j] == true)
			return 0;
		
		if(dp[i][j] != 0)
			return dp[i][j];
		
		int sum = Integer.MIN_VALUE;
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < n && y >= 0 && y < m)
				sum = Math.max(sum, grid[i][j] + getMaximumGold(grid, x, y));
		}

		visited[i][j] = false;
		dp[i][j] =  sum;
		
		return dp[i][j];
	}
}
