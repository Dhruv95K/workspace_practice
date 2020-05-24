package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NQueens51 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(solveNQueens(n));

	}

	static List<List<String>> res;

	public static List<List<String>> solveNQueens(int n) {
		res = new ArrayList<List<String>>();
		int[][] board = new int[n][n];

		int count = solveNQueens(board, 0);
		System.out.println(count);
		
		return res;
	}

	private static int solveNQueens(int[][] board, int col) {
		if (col == board[0].length) {
			print(board);
			return 1;
		}
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				count += solveNQueens(board, col + 1);
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

	private static void print(int[][] board) {
		String s;
		List<String> l = new ArrayList<String>();

		for (int i = 0; i < board.length; i++) {
			s = "";
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 1)
					s+="Q";
				else
					s+=".";
			}
			l.add(s);
		}
		
		res.add(l);
	}
}
