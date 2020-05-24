package backtracking;

/*
37. Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.

Note:
	1. The given board contain only digits 1-9 and the character '.'.
	2. You may assume that the given Sudoku puzzle will have a single unique solution.
	3. The given board size is always 9x9.
*/
public class SudokuSolver37 {

	public void solveSudoku(char[][] board) {

		solve(board);
	}

	private boolean solve(char[][] board) {
		Cell cell = new Cell();

		if (!findUnassigned(board, cell))
			return true;

		for (int i = 1; i <= 9; i++) {
			if (isSafe(board, cell, i)) {
				board[cell.r][cell.c] = Character.forDigit(i, 10);
				if (solve(board))
					return true;
				board[cell.r][cell.c] = '.';
			}
		}

		return false;
	}

	private boolean isSafe(char[][] board, Cell cell, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[i][cell.c] == Character.forDigit(num, 10))
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (board[cell.r][i] == Character.forDigit(num, 10))
				return false;
		}

		int box_r = cell.r - cell.r % 3;
		int box_c = cell.c - cell.c % 3;
		for (int i = box_r; i < box_r + 3; i++) {
			for (int j = box_c; j < box_c + 3; j++) {
				if(board[i][j] == Character.forDigit(num, 10))
					return false;
			}
		}
		
		return true;
	}

	private boolean findUnassigned(char[][] board, Cell cell) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					cell.r = i;
					cell.c = j;
					return true;
				}
			}
		}
		
		return false;
	}
}

class Cell {
	int r = 0, c = 0;

	public Cell(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public Cell() {
		// TODO Auto-generated constructor stub
	}
}