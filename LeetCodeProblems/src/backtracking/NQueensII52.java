package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueensII52 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(totalNQueens(n));

	}

	public static int totalNQueens(int n) {
		int[][] board = new int[n][n];

		return totalNQueens(board, 0);
	}
	
	private static int totalNQueens(int[][] board, int col) {
		if (col == board[0].length) {
			return 1;
		}
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				count += totalNQueens(board, col + 1);
				board[i][col] = 0;
			}
		}

		return count;
	}

	private static boolean isSafe(int[][] board, int row, int col) {

		for (int i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (int i = row, j = col; i < board.length && j >= 0; i++, j--)
			if (board[i][j] == 1)
				return false;

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

}
