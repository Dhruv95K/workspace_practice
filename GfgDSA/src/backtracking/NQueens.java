package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		solveNQueens(n);
		
		System.out.println("There are " + count + " solutions");
		for(ArrayList<String> arr : res) {
			for(String s : arr) {
				System.out.println(s);
			}
			System.out.println(" "); 
		}
	}

	static ArrayList<ArrayList<String>> res;
	static int count = 0;
	
	public static ArrayList<ArrayList<String>> solveNQueens(int n) {
		res = new ArrayList<>();
		int[][] board = new int[n][n];
		count = solveNQueens(board, 0);
		return res;
	}

	private static int solveNQueens(int[][] board, int col) {

		if (col == board.length) {
			storePattern(board);
			return 1;
		}
		
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			if (isSafeMove(board, i, col)) {
				board[i][col] = 1;
				count += solveNQueens(board, col + 1);
				board[i][col] = 0;
			}
		}
		
		return count;
	}

	private static boolean isSafeMove(int[][] board, int curr_row, int curr_col) {
		if (curr_col == 0)
			return true;

		for (int i = 0; i < curr_col; i++)
			if (board[curr_row][i] == 1)
				return false;

		for (int i = curr_row, j = curr_col; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j]==1)
				return false;
		}
		
		for (int i = curr_row, j = curr_col; i < board.length && j >= 0; i++, j--) {
			if(board[i][j]==1)
				return false;
		}

		return true;
	}

	private static void storePattern(int[][] board) {
		// TODO Auto-generated method stub
		int n = board.length;
		int m = n;
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s = "";
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0)
					s += ".";
				else
					s += "Q";
			}
			arr.add(s);
		}

		res.add(arr);
	}
}
