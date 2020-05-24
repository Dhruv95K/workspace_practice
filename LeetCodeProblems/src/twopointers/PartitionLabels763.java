package twopointers;
/*
763. Partition Labels
A string S of lowercase letters is given. We want to partition this string into as many parts as 
possible so that each letter appears in at most one part, and return a list of integers 
representing the size of these parts.

Example 1:
	Input: S = "ababcbacadefegdehijhklij"
	Output: [9,7,8]
	Explanation:
	The partition is "ababcbaca", "defegde", "hijhklij".
	This is a partition so that each letter appears in at most one part.
	A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:
	1. S will have length in range [1, 500].
	2. S will consist of lowercase letters ('a' to 'z') only.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(partitionLabels(s));

	}

	public static List<Integer> partitionLabels(String s) {
		List<Integer> ans = new ArrayList<>();
		int[] lastOccurence = new int[26];

		for (int ind = 0; ind < s.length(); ind++) {
			lastOccurence[s.charAt(ind) - 'a'] = ind;
		}

		int j = 0, start = 0;

		for (int i = 0; i < s.length(); i++) {
			j = Math.max(j, lastOccurence[s.charAt(i) - 'a']);
			if (i == j) {
				ans.add(j - start + 1);
				start = i + 1;
			}
		}

		return ans;
	}

}
