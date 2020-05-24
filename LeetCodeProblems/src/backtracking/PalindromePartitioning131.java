package backtracking;

/*
 131. Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:
	Input: "aab"
	Output:
	[
	  ["aa","b"],
	  ["a","a","b"]
	]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

	}

	static List<List<String>> result;

	public List<List<String>> partition(String s) {
		result = new ArrayList<>();
		int n = s.length();
		boolean[][] isPal = new boolean[n][n];

		for (int l = 1; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;
				if (l == 1)
					isPal[i][j] = true;
				else if (l == 2 && s.charAt(i) == s.charAt(j))
					isPal[i][j] = true;
				else if (s.charAt(i) == s.charAt(j)) {
					isPal[i][j] = isPal[i + 1][j - 1];
				}
			}
		}
		
		List<String> temp = new ArrayList<>();
		partition(s,0,isPal,temp);
		
		return result;
	}

	private void partition(String s, int ind, boolean[][] isPal, List<String> temp) {
		if(ind == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i  = ind;i<s.length();i++) {
			if(isPal[ind][i] == true) {
				temp.add(s.substring(ind, i+1));
				partition(s, i+1, isPal, temp);
				temp.remove(temp.size()-1);
			}
		}
		
	}
}
