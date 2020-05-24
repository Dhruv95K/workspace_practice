package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
	Input: s = "leetcode", wordDict = ["leet", "code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
	Input: s = "applepenapple", wordDict = ["apple", "pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	             Note that you are allowed to reuse a dictionary word.

Example 3:
	Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output: false
*/
public class WordBreak139 {

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

	public static boolean wordBreak(String s, List<String> wordDict) {
		//return wordBreak(s, 0, wordDict);
		int n = s.length();
		boolean[] dp = new boolean[s.length()];
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<=i;j++) {
				if(wordDict.contains(s.substring(j, i+1)) && (j==0 || dp[j-1] == true))
					dp[i] = true;
			}
		}
		
		return dp[s.length()-1];
	}

	public static boolean wordBreak(String s, int ind, List<String> wordDict) {

		if (ind == s.length())
			return true;

		for (int i = ind; i < s.length(); i++) {
			if (wordDict.contains(s.substring(ind, i + 1))) {
				if (wordBreak(s, i + 1, wordDict))
					return true;
			}
		}

		return false;
	}

}
