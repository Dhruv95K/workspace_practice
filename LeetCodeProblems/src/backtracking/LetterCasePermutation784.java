package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
784. Letter Case Permutation
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
Return a list of all possible strings we could create.

Examples:
	Input: S = "a1b2"
	Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

	Input: S = "3z4"
	Output: ["3z4", "3Z4"]

	Input: S = "12345"
	Output: ["12345"]

Note:
	1. S will be a string with length between 1 and 12.
	2. S will consist only of letters or digits.
*/

public class LetterCasePermutation784 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		List<String> ans = letterCasePermutationBFS(s);
		System.out.println(ans);
	}

	public static List<String> letterCasePermutationBFS(String s) {
		List<String> res = new ArrayList<String>();
		Queue<String> q = new LinkedList<>();
		q.add(s);

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)))
				continue;
			int n = q.size();
			for (int j = 0; j < n; j++) {
				char[] st = q.poll().toCharArray();
				st[i] = Character.toUpperCase(st[i]);
				q.add(String.valueOf(st));

				st[i] = Character.toLowerCase(st[i]);
				q.add(String.valueOf(st));
			}
		}

		return new LinkedList<>(q);
	}

	public static List<String> letterCasePermutation(String s) {
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder(s);
		letterCasePermutation(sb, 0, res);

		return res;
	}

	private static void letterCasePermutation(StringBuilder sb, int i, List<String> res) {
		if (i == sb.length()) {
			res.add(sb.toString());
			return;
		}

		if (!Character.isDigit(sb.charAt(i))) {
			sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));

			letterCasePermutation(sb, i + 1, res);

			sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
		}

		letterCasePermutation(sb, i + 1, res);

	}

}
