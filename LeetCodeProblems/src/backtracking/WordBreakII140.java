package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
140. Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to 
construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:
	1. The same word in the dictionary may be reused multiple times in the segmentation.
	2. You may assume the dictionary does not contain duplicate words.

Example 1:	
	Input:
	s = "catsanddog"
	wordDict = ["cat", "cats", "and", "sand", "dog"]
	Output:
	[
	  "cats and dog",
	  "cat sand dog"
	]
		
Example 2:	
	Input:
	s = "pineapplepenapple"
	wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
	Output:
	[
	  "pine apple pen apple",
	  "pineapple pen apple",
	  "pine applepen apple"
	]
	Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:	
	Input:
	s = "catsandog"
	wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output:
	[]
*/

public class WordBreakII140 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());

		List<String> dict = new ArrayList<>();
		String[] input = br.readLine().split(", ");

		for (int i = 0; i < n; i++)
			dict.add(input[i]);

		System.out.println(wordBreak(s, dict));
	}

	static List<String> res;

	public static List<String> wordBreak(String s, List<String> wordDict) {
		res = new ArrayList<>();
		int n = s.length();
		boolean[] dp = new boolean[s.length()];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1] == true))
					dp[i] = true;
			}
		}

		wordBreak(s, wordDict, 0, "", dp);

		return res;
	}

	private static void wordBreak(String s, List<String> wordDict, int ind, String cur, boolean[] dp) {
		if (ind == s.length()) {
			res.add(cur.trim());
			return;
		}

		for (int i = ind; i < s.length(); i++) {
			if (dp[i]) {
				String temp = s.substring(ind, i + 1);
				if(wordDict.contains(temp))
					wordBreak(s, wordDict, i + 1, cur + temp + " ", dp);
			}
		}
	}
}
