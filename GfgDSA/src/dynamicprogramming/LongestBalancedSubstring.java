package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestBalancedSubstring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		System.out.println(LBS(input));
	}

	private static int LBS(String input) {
		// TODO Auto-generated method stub
		int n = input.length();
		int[] dp = new int[n];
		dp[0] = 0;
		int ans = 0;
		
		for (int i = 1; i < n; i++) {
			if (input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '<')
				dp[i] = 0;
			else {
				if ((input.charAt(i - 1) == '{' && input.charAt(i) == '}')
						|| (input.charAt(i - 1) == '[' && input.charAt(i) == ']')
						|| (input.charAt(i - 1) == '<' && input.charAt(i) == '>')
						|| (input.charAt(i - 1) == '(' && input.charAt(i) == ')'))
					dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
				else {
					int ind = i - dp[i - 1] - 1;
					if(ind < 0)
						dp[i]=0;
					else if ((input.charAt(i) == '}' && input.charAt(ind) == '{')
							|| (input.charAt(i) == ')' && input.charAt(ind) == '(')
							|| (input.charAt(i) == ']' && input.charAt(ind) == '[')
							|| (input.charAt(i) == '>' && input.charAt(ind) == '<')) {
						dp[i] += dp[i - 1];
						if (ind - 1 >= 0) {
							dp[i] += dp[ind - 1];
						}
						dp[i] += 2;
					}
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}

}
