package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*212. Word Search II
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:	
	Input: 
	board = [
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
	]
	words = ["oath","pea","eat","rain"]
	
	Output: ["eat","oath"]

Note:
	1. All inputs are consist of lowercase letters a-z.
	2. The values of words are distinct.
*/
public class WordSearchII212 {

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

		String[] words = br.readLine().split(" ");

	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> ans = new ArrayList<>();
		
		for(String word : words) {
			if(WordSearch79.exist(board, word))
				ans.add(word);
		}
		
		return ans;
	}

}
