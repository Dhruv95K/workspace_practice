package backtracking;
/*
79. Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	
	Given word = "ABCCED", return true.
	Given word = "SEE", return true.
	Given word = "ABCB", return false.
		
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordSearch79 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		char[][] board = new char[n][m];
		String[] input;
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++)
				board[i][j] = input[j].charAt(0);
		}

		String word = br.readLine();

		System.out.println(exist(board, word));

	}

	public static boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;

		boolean visited[][] = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (doDFS(board, word, i, j, 0, visited))
						return true;
				}
			}
		}

		return false;
	}

	private static boolean doDFS(char[][] board, String word, int i, int j, int ind, boolean[][] visited) {
		int n = board.length;
		int m = board[0].length;

		if (ind == word.length())
			return true;

		if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != word.charAt(ind))
			return false;

		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (doDFS(board, word, x, y, ind + 1, visited))
				return true;

		}

		visited[i][j] = false;

		return false;
	}

}

/*
 * [["b","a","a","b","a","b"],["a","b","a","a","a","a"],["a","b","a","a","a","b"
 * ],["a","b","a","b","b","a"],["a","a","b","b","a","b"],["a","a","b","b","b",
 * "a"],["a","a","b","a","a","b"]]"aabbbbabbaababaaaabababbaaba"
 */