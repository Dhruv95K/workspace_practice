package backtracking;
/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(read.readLine());

		List<String> ans = generateParenthesis(n);
		System.out.println(ans);
	}

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generateParenthesis(n, "", 0, 0, result);

		return result;
	}

	private static void generateParenthesis(int n, String comb, int open, int close, List<String> result) {
		if (open == n && close == n) {
			result.add(comb);
			return;
		}

		if (open > n)
			return;

		generateParenthesis(n, comb + "(", open + 1, close, result);

		if (close < open)
			generateParenthesis(n, comb + ")", open, close + 1, result);

	}

}
