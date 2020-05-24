import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:
	Input: "(()"
	Output: 2
	Explanation: The longest valid parentheses substring is "()"

Example 2:
	Input: ")()())"
	Output: 4
	Explanation: The longest valid parentheses substring is "()()"

*/

public class LongestValidParentheses {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int ans = longestValidParantheses(s);
		System.out.println(ans);
	}

	private static int longestValidParantheses(String s) {
		int n = s.length();
		int[] dp = new int[n];
		int res = 0;
		
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == '(')
				dp[i] = 0;
			else {
				if (s.charAt(i - 1) == '(')
					dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
				else{
					int ind = i - dp[i-1] - 1;
					if(ind >=0 && s.charAt(ind) == '(')
						dp[i] = 2 + dp[i-1] + (ind > 0 ? dp[ind-1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}

}
