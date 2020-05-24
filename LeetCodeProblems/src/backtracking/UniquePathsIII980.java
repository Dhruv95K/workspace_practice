package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
980. Unique Paths III
On a 2-dimensional grid, there are 4 types of squares:
	1 represents the starting square.  There is exactly one starting square.
	2 represents the ending square.  There is exactly one ending square.
	0 represents empty squares we can walk over.
	-1 represents obstacles that we cannot walk over.
	
Return the number of 4-directional walks from the starting square to the ending square, that walk over every 
non-obstacle square exactly once.

Example 1:
	Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
	Output: 2
	Explanation: We have the following two paths: 
	1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
	2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
	Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
	Output: 4
	Explanation: We have the following four paths: 
	1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
	2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
	3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
	4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
	
Example 3:
	Input: [[0,1],[2,0]]
	Output: 0
	Explanation: 
	There is no path that walks over every empty square exactly once.
	Note that the starting and ending square can be anywhere in the grid.
 
Note:
	1. 1 <= grid.length * grid[0].length <= 20
 */

public class UniquePathsIII980 {

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
		
		System.out.println(uniquePathsIII(arr));
	}

	public static int uniquePathsIII(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int toVisit = 0;
		
		for(int i =0;i<grid.length;i++) {
			for(int j = 0;j<grid[0].length;j++) {
				if(grid[i][j] != -1) 
					toVisit++;
			}
		}
		
		for(int i =0;i<grid.length;i++) {
			for(int j = 0;j<grid[0].length;j++) {
				if(grid[i][j] == 1) 
					return uniquePathsCount(grid,i,j,visited,toVisit);
			}
		}
		
		return -1;
	}

	private static int uniquePathsCount(int[][] grid, int i, int j, boolean[][] visited, int toVisit) {
		if(i<0 || i>=grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || visited[i][j])
			return 0;
		
		if(grid[i][j] == 2) { 
			if( toVisit == 1)
				return 1;
			return 0;
		}
		
		int count = 0;
		int[] dx = {0,-1,0,1};
		int[] dy = {1,0,-1,0};
		
		visited[i][j] = true;
		for(int k = 0;k<4;k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
			count += uniquePathsCount(grid, x, y, visited, toVisit - 1);
		}
		visited[i][j] = false;
		
		return count;
	}

	private static boolean everyCellVisited(int[][] grid, boolean[][] visited) {
		for(int i = 0;i<visited.length;i++)
			for(int j = 0;j<visited[0].length;j++)
				if(visited[i][j] == false && grid[i][j] != -1)
					return false;
		
		return true;
	}

}
