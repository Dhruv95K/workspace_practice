package backtracking;
/*
357. Count Numbers with Unique Digits

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ¡Ü x < 10n.

Example:	
	Input: 2
	Output: 91 
	Explanation: The answer should be the total numbers in the range of 0 ¡Ü x < 100, 
	             excluding 11,22,33,44,55,66,77,88,99             
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountNumbersWithUniqueDigits357 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int ans = countNumbersWithUniqueDigits(n);
		System.out.println(ans);
	}

	static boolean[] visited;
	static int count;

	public static int countNumbersWithUniqueDigits(int n) {
		if(n == 0)
            return 1;
        if(n == 1)
            return 10;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 10;
		dp[2] = 81;
		for (int i = 3; i <= n; i++) {
			dp[i] = (9 - i + 2) * dp[i - 1];
		}

		int ans = 0;
		for (int i : dp)
			ans += i;

		return ans;
	}

}
