package twopointers;
/*
392. Is Subsequence
Given a string s and a string t, check if s is subsequence of t.
You may assume that there is only lower case English letters in both s and t. t is potentially a very long 
(length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) 
of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a 
subsequence of "abcde" while "aec" is not).

Example 1:
	s = "abc", t = "ahbgdc"
	Return true.

Example 2:
	s = "axc", t = "ahbgdc"
	Return false.
	
Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to 
see if T has its subsequence. In this scenario, how would you change your code?

Credits:
	Special thanks to @pbrother for adding this problem and creating all test cases.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IsSubsequence392 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();

		System.out.println(isSubsequence(s, t));
	}

	static boolean[][] cache;

	public static boolean isSubsequence(String s, String t) {

		/*
		 * cache = new boolean[s.length()][t.length()]; for(boolean[] arr:cache)
		 * Arrays.fill(arr,false);
		 * 
		 * // return isSubsequence(s,t,0,0);
		 */
		if(s.length() == 0 || t.length() == 0)
			return false;
			
		int i = 0;
		for (int j = 0; j < t.length(); j++) {
			if (s.charAt(i) == t.charAt(j))
				i++;
		}

		return i == s.length();
	}

	public static boolean isSubsequence(String s, String t, int i, int j) {
		if (i == s.length())
			return true;
		if (j == t.length())
			return false;

		if (cache[i][j] == true)
			return true;

		if (s.charAt(i) == t.charAt(j))
			cache[i][j] = isSubsequence(s, t, i + 1, j + 1);
		else
			cache[i][j] = isSubsequence(s, t, i, j + 1);

		return cache[i][j];

	}

}
