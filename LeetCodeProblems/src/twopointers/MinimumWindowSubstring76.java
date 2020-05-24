package twopointers;
/*
76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters 
in T in complexity O(n).

Example:
	Input: S = "ADOBECODEBANC", T = "ABC"
	Output: "BANC"
		
Note:
	1. If there is no such window in S that covers all characters in T, return the empty string "".
	2. If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumWindowSubstring76 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		System.out.println(minWindow(S, T));
	}

	public static String minWindow(String s, String t) {
		int[] countS = new int[256];
		int[] countT = new int[256];

		for (char c : t.toCharArray())
			countT[c]++;

		int start = 0, minLen = Integer.MAX_VALUE, start_index = -1;
		int count = 0;

		for (int j = 0; j < s.length(); j++) {
			countS[s.charAt(j)]++;

			if (countT[s.charAt(j)] != 0 
					&& countT[s.charAt(j)] >= countS[s.charAt(j)])
				count++;

			if (count == t.length()) {
				while (countS[s.charAt(start)] > countT[s.charAt(start)]) {
					countS[s.charAt(start)]--;
					start++;
				}

				int curlen = j - start + 1;
				if (minLen > curlen) {
					minLen = curlen;
					start_index = start;
				}
			}
		}

		if (start_index == -1)
			return "";

		return s.substring(start_index, start_index + minLen );

	}

}
