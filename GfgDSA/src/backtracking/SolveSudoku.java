package backtracking;

import java.util.Scanner;

public class SolveSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int grid[][] = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					grid[i][j] = sc.nextInt();
			}

			if (new Sudoku().SolveSudoku(grid) == true)
				new Sudoku().printGrid(grid);
			else
				System.out.print("NO solution exists");
			System.out.println();

		}
	}

}

class cell {
	int r, c;
}

class Sudoku {
	private static boolean isSafe(int[][] grid, int row, int col, int num) {
		int n = grid.length;
		//checking in same row
		for(int c=0;c<n;c++) {
			if(grid[row][c] == num)
				return false;
		}
		
		//checking in same column
		for(int r=0;r<n;r++) {
			if(grid[r][col] == num)
				return false;
		}
		
		//checking in the box
		int boxSize = (int) Math.sqrt(n);
		int boxRowStart = row - row%boxSize;
		int boxColStart = col - col%boxSize;
		
		for(int i=boxRowStart;i<boxRowStart+boxSize;i++) {
			for(int j=boxColStart;j<boxColStart+boxSize;j++) {
				if(grid[i][j]==num)
					return false;
			}
		}
		
		return true;
	}
	
	static boolean SolveSudoku(int grid[][]) {
		cell c = new cell();

		if (!findUnassignedCell(grid, c))
			return true;
		
		int row = c.r;
		int col = c.c;
		
		for(int num=1;num<=9;num++) {
			if(isSafe(grid,row,col,num)) {
				grid[row][col]=num;
				if(SolveSudoku(grid))
					return true;
				grid[row][col]=0;
			}
		}
		
		return false;
	}

	private static boolean findUnassignedCell(int[][] grid, cell c) {
		int n = grid.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j] == 0) {
					c.r = i;
					c.c = j;
					return true;
				}
			}
		}
		return false;
	}

	public void printGrid(int[][] grid) {
		// TODO Auto-generated method stub
		int n = grid.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
	}

}